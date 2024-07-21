package org.example.game;

import org.example.content.GameContent;
import org.example.dialog.Dialog;
import org.example.dialog.impl.LetterDialog;
import org.example.model.HiddenWord;

import java.util.HashSet;
import java.util.Set;

public class Game {

    private static final String INVALID_CHARACTER_TEXT = "Invalid character";
    private static final int ERRORS_TO_LOSE = 6;

    private final HiddenWord hiddenWord;
    private final GameContent gameContent;
    private final Set<Character> wrongChars = new HashSet<>();

    public Game(final HiddenWord hiddenWord, final GameContent gameContent) {
        this.hiddenWord = hiddenWord;
        this.gameContent = gameContent;
    }

    public void start() {
        while (true) {
            final String guessCharText = gameContent.getGuessCharText(
                    getErrorsCount(),
                    getErrorsLeft(),
                    wrongChars.toString(),
                    hiddenWord.getWordWithMask()
            );
            final Dialog<Character> letterDialog = new LetterDialog(guessCharText, INVALID_CHARACTER_TEXT);
            final char inputChar = letterDialog.input();

            tryToGuess(inputChar);

            if (isLost()) {
                System.out.println(gameContent.getLostText(getErrorsCount(), hiddenWord.getWord()));
                return;
            }
            if (isWon()) {
                System.out.println(gameContent.getWonText(getErrorsCount(), hiddenWord.getWordWithMask()));
                return;
            }
        }

    }

    public void tryToGuess(final char inputChar) {
        if (isWrongChar(inputChar)) {
            wrongChars.add(inputChar);
        }
    }

    private boolean isWrongChar(final char inputChar) {
        return !hiddenWord.guessChar(inputChar);
    }

    private boolean isLost() {
        return wrongChars.size() == ERRORS_TO_LOSE;
    }

    private boolean isWon() {
        return !hiddenWord.getWordWithMask().contains(HiddenWord.HIDDEN_CHAR_MASK);
    }

    private int getErrorsCount() {
        return wrongChars.size();
    }

    private int getErrorsLeft() {
        return ERRORS_TO_LOSE - getErrorsCount();
    }
}
