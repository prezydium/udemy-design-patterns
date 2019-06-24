package org.prezydium.decorator;

public class DecoratorTask {
}

class Bird {
    public int age;

    public String fly() {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard {
    public int age;

    public String crawl() {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon {
    private int age;

    private Bird bird;
    private Lizard lizard;

    public Dragon() {
        bird = new Bird();
        lizard = new Lizard();
    }

    public void setAge(int age) {
        bird.age = age;
        lizard.age = age;
    }

    public String fly() {
        return bird.fly();
    }

    public String crawl() {
        return lizard.crawl();
    }
}