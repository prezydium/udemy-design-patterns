package org.prezydium.singleton;

import java.util.function.Supplier;

public class SingletonTester {

    public static boolean isSingleton(Supplier<Object> func) {
        Object object1 = func.get();
        Object object2 = func.get();
        return object1 == object2;
    }
}