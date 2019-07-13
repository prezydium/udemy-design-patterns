package org.prezydium.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MementoTask {
}

class Token {
    public int value = 0;

    public Token(int value) {
        this.value = value;
    }
}

class Memento {
    public List<Token> tokens = new ArrayList<>();
}

class TokenMachine {
    public List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value) {
        return addToken(new Token(value));
    }

    public Memento addToken(Token token) {
        tokens.add(token);
        ArrayList<Token> copyOfTokens = new ArrayList<>();
        Memento memento = new Memento();
        tokens.forEach(tok -> copyOfTokens.add(new Token(tok.value)));
        memento.tokens = copyOfTokens;
        return memento;
    }

    public void revert(Memento m) {
        this.tokens = m.tokens.stream()
                .map(x -> new Token(x.value))
                .collect(Collectors.toList());
    }
}