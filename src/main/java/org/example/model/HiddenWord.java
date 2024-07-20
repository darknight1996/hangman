package org.example.model;

import java.util.HashSet;
import java.util.Set;

public class HiddenWord {

    public static final String HIDDEN_CHAR_MASK = "*";

    private final String word;
    private final Set<Character> guessedChars = new HashSet<>();

    public HiddenWord(String word) {
        this.word = word;
    }

    public boolean guessChar(char character) {
        if (word.indexOf(character) == -1) {
            return false;
        } else {
            guessedChars.add(character);
            return true;
        }
    }

    public String getWordWithMask() {
        StringBuilder sb = new StringBuilder();
        for (char character : word.toCharArray()) {
            if (guessedChars.contains(character)) {
                sb.append(character);
            } else {
                sb.append(HIDDEN_CHAR_MASK);
            }
        }
        return sb.toString();
    }

    public String getWord() {
        return word;
    }

}
