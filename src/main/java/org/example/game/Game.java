package org.example.game;

import org.example.constants.Constants;
import org.example.dialog.Dialog;
import org.example.dialog.impl.CharDialog;
import org.example.model.HiddenWord;
import org.example.content.GameContent;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private final HiddenWord hiddenWord;
    private final GameContent gameContent;
    private final Set<Character> wrongChars = new HashSet<>();

    public Game(HiddenWord hiddenWord, GameContent gameContent) {
        this.hiddenWord = hiddenWord;
        this.gameContent = gameContent;
    }

    public void start() {

        while (true) {
            final String guessCharText = gameContent.getGuessCharText(getErrorsCount(), wrongChars.toString());
            final Dialog<Character> characterDialog = new CharDialog(guessCharText);
            final char inputChar = characterDialog.input();

            tryToGuess(inputChar);

            if (isLost()) {
                System.out.println(gameContent.getLostText(getErrorsCount()));
                return;
            }
            if (isWon()) {
                System.out.println(gameContent.getWonText(getErrorsCount()));
                return;
            }
        }

    }

    public void tryToGuess(char inputChar) {
        if (isWrongChar(inputChar)) {
            wrongChars.add(inputChar);
        }
    }

    private boolean isWrongChar(final char inputChar) {
        return !hiddenWord.guessChar(inputChar);
    }

    private boolean isLost() {
        return wrongChars.size() == Constants.ERRORS_TO_LOSE;
    }

    private boolean isWon() {
        return !hiddenWord.getWordWithMask().contains(Constants.HIDDEN_CHAR_MASK);
    }

    private int getErrorsCount() {
        return wrongChars.size();
    }
}
