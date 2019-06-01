package org.prezydium;


import org.prezydium.builder.CodeBuilder;

public class App {
    public static void main(String[] args) {
        String classPerson = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int")
                .toString();
        System.out.println(classPerson);
    }
}
