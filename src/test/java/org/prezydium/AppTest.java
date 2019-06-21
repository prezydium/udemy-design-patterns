package org.prezydium;

import org.junit.Test;
import org.prezydium.builder.CodeBuilder;
import org.prezydium.factory.Person;
import org.prezydium.factory.PersonFactory;
import org.prezydium.factory.SecurePerson;
import org.prezydium.prototype.Line;
import org.prezydium.singleton.SimpleSingleton;
import org.prezydium.singleton.SingletonTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void firstExercise() {
        String classPerson = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int")
                .toString();
        System.out.println(classPerson);
    }

    @Test
    public void secondExercise() {
        System.out.println(new Person(33, "Zbigniev"));
        System.out.println(new PersonFactory().createPerson("Anna"));
        System.out.println(new PersonFactory().createPerson("Pearl"));
        System.out.println(SecurePerson.createSecurePerson("Jeff"));
        System.out.println(SecurePerson.createSecurePerson("Adolph"));
    }

    @Test
    public void thirdExercise() {
        Line line1 = new Line(new Line.Point(1, 98), new Line.Point(10, 88));
        Line line2 = line1.deepCopy();
        System.out.println(line1);
        System.out.println(line2);

        assertEquals(line1, line2);
    }

    @Test
    public void fourthExercise() {
        assertTrue( SingletonTester.isSingleton(SimpleSingleton::getInstance) );
    }
}
