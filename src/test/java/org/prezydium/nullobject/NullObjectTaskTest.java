package org.prezydium.nullobject;

import org.junit.Test;

public class NullObjectTaskTest {

    @Test
    public void doTest() throws Exception {
        NullLog nullLog = new NullLog();
        Account account = new Account(nullLog);
        account.someOperation();
    }
}