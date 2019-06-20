package org.prezydium.singleton;

public class SimpleSingleton {

    private static final SimpleSingleton INSTANCE = new SimpleSingleton();

    public static SimpleSingleton getInstance(){
        return INSTANCE;
    }

    private SimpleSingleton() {
    }


}
