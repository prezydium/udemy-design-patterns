package org.prezydium.interpreter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionProcessorTest {

    @Test
    public void test() {
        ExpressionProcessor ep = new ExpressionProcessor();
        ep.variables.put('x', 5);
        ep.variables.put('z', 3);

        assertEquals(1, ep.calculate("1"));
        assertEquals(134, ep.calculate("1+2+123+5+z"));
        assertEquals(6, ep.calculate("1+x"));
        assertEquals(0, ep.calculate("1+xy"));
    }

}