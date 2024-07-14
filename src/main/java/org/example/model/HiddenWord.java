package org.example.model;

import org.example.constants.Constants;

import java.util.HashSet;
import java.util.Set;

public class HiddenWord {

    private final String word;
    private final Set<Character> guessedChars = new HashSet<>();
    private final Set<Character> wrongChars = new HashSet<>();

    public HiddenWord(String word) {
        this.word = word;
    }

    public void tryToGuess(char character) {
        if (word.indexOf(character) == -1) {
            wrongChars.add(character);
        } else {
            guessedChars.add(character);
        }
    }

    public String getWordWithMask() {
        StringBuilder sb = new StringBuilder();
        for (char character : word.toCharArray()) {
            if (guessedChars.contains(character)) {
                sb.append(character);
            } else {
                sb.append(Constants.HIDDEN_CHAR_MASK);
            }
        }
        return sb.toString();
    }

    public String getWord() {
        return word;
    }

    public Set<Character> getWrongChars() {
        return wrongChars;
    }

    public int getErrorsCount() {
        return wrongChars.size();
    }
}
