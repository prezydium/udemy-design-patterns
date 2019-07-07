package org.prezydium.interpreter;

import java.util.HashMap;
import java.util.Map;

public class InterpreterTask {
}

class ExpressionProcessor {
    public Map<Character, Integer> variables = new HashMap<>();
    private final static String SPLITTING_REGEX = "(?<=[+-])";

    enum Action {
        NONE, ADD, SUBSTRACT
    }

    public static class ExpessionToken {
        private final int number;
        private final Action nextAction;

        public ExpessionToken(int number, Action nextAction) {
            this.number = number;
            this.nextAction = nextAction;
        }
    }

    public int calculate(String expression) {
        String[] elements = expression.split(SPLITTING_REGEX);
        ExpessionToken[] expressionTokens = new ExpessionToken[elements.length];
        for (int i = 0; i < elements.length; i++) {
            expressionTokens[i] = createToken(elements[i]);
        }
        int result = 0;
        Action nextAction = Action.NONE;
        for (ExpessionToken expessionToken : expressionTokens) {
            if (expessionToken == null) {
                return 0;
            }
            int currentNumber = expessionToken.number;
            switch (nextAction) {
                case NONE:
                    result = currentNumber;
                    break;
                case ADD:
                    result += currentNumber;
                    break;
                case SUBSTRACT:
                    result -= currentNumber;
                    break;
            }
            nextAction = expessionToken.nextAction;
        }
        return result;
    }

    private ExpessionToken createToken(String s) {
        String operand = s.substring(s.length() - 1);
        String value = s.replaceAll("[+-]", "");
        int number = 0;
        if (value.matches("[a-zA-Z]+")) {
            Character variable = value.charAt(0);
            if (value.length() > 1 || !variables.containsKey(variable)) {
                return null;
            } else {
                number = variables.get(variable);
            }
        } else {
            number = Integer.valueOf(value);
        }
        Action action;
        switch (operand) {
            case "+":
                action = Action.ADD;
                break;
            case "-":
                action = Action.SUBSTRACT;
                break;
            default:
                action = Action.NONE;
        }
        return new ExpessionToken(number, action);
    }
}

