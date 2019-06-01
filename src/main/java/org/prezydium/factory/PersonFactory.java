package org.prezydium.factory;

public class PersonFactory {

    private static int count = 0;

    public Person createPerson(String name) {
        return new Person(count++, name);
    }
}
