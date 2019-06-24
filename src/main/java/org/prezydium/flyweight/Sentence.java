package org.prezydium.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Sentence {

    private Map<Integer, WordToken> wordTokens = new HashMap<>();
    private String[] words;
    private final static String SPACE = " ";

    public Sentence(String plainText) {
        words = plainText.split(SPACE);
    }

    public WordToken getWord(int index) {
        if (wordTokens.containsKey(index)) {
            return wordTokens.get(index);
        } else {
            wordTokens.put(index, new WordToken());
            return wordTokens.get(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(wordTokens.containsKey(i) ?
                    wordTokens.get(i).capitalize ?
                           words[i].toUpperCase() : words[i]
                    : words[i]);
            sb.append(SPACE);
        }
        return sb.toString().trim();
    }

    class WordToken {
        public boolean capitalize;
    }
}
