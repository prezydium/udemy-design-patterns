package org.prezydium.flyweight;

import org.junit.Test;

public class SentenceTest {

    @Test
    public void flyweightExercise() {
        Sentence sentence = new Sentence("What's up doc");
        sentence.getWord(1).capitalize = true;
        System.out.println(sentence);
    }

}