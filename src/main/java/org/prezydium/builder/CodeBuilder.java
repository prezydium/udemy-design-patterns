package org.prezydium.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CodeBuilder {

    private String className;
    private List<Field> listOfFields = new ArrayList<>();

    public CodeBuilder(String className) {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type) {
        listOfFields.add(new Field(type, name));
        return this;
    }

    @Override
    public String toString() {
        String fields = listOfFields.stream()
                .map(f -> "  " + f.toString())
                .collect(Collectors.joining());
        return "public class " + className + "\n" + "{\n" + fields + "}";

    }

    public static class Field {
        private final String type;
        private final String value;

        Field(String type, String value) {
            this.type = type;
            this.value = value;
        }

        @Override
        public String toString() {
            return "public " + type + " " + value + ";\n";
        }
    }

}
