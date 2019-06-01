package org.prezydium;


import org.prezydium.builder.CodeBuilder;
import org.prezydium.factory.Person;
import org.prezydium.factory.PersonFactory;
import org.prezydium.factory.SecurePerson;

public class App {
    public static void main(String[] args) {
        firstExercise();
        secondExercise();
    }

    private static void firstExercise(){
        String classPerson = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int")
                .toString();
        System.out.println(classPerson);
    }

    private static void secondExercise(){
        System.out.println(new Person(33, "Zbigniev"));
        System.out.println(new PersonFactory().createPerson("Anna"));
        System.out.println(new PersonFactory().createPerson("Pearl"));
        System.out.println(SecurePerson.createSecurePerson("Jeff"));
        System.out.println(SecurePerson.createSecurePerson("Adolph"));

    }
}
