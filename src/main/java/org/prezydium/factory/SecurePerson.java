package org.prezydium.factory;

public class SecurePerson {

    private int id;
    private String name;
    private static int personCounter;

    private SecurePerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static SecurePerson createSecurePerson(String name){
        return new SecurePerson(personCounter++, name);
    }

    @Override
    public String toString() {
        return "SecurePerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
