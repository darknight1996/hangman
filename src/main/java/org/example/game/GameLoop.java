package org.example.game;

import org.example.constants.Constants;
import org.example.model.HiddenWord;
import org.example.render.GameTextRenderer;
import org.example.validator.Validator;

import java.util.Scanner;

public class GameLoop {
    private final HiddenWord hiddenWord;
    private final GameTextRenderer gameTextRenderer;
    private final Validator validator;
    private final Scanner scanner;


    public GameLoop(HiddenWord hiddenWord, GameTextRenderer gameTextRenderer, Validator validator, Scanner scanner) {
        this.hiddenWord = hiddenWord;
        this.gameTextRenderer = gameTextRenderer;
        this.validator = validator;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            gameTextRenderer.renderGuessCharText();

            final String inputStringFromConsole = scanner.nextLine().toLowerCase();
            if (!validator.isSingleLetter(inputStringFromConsole)) {
                gameTextRenderer.renderInvalidInputStringText();
                continue;
            }

            final char inputChar = inputStringFromConsole.charAt(0);
            if (validator.isValidChar(inputChar)) {
                hiddenWord.tryToGuess(inputChar);
            } else {
                gameTextRenderer.renderInvalidCharText();
                continue;
            }

            if (isLost(hiddenWord)) {
                gameTextRenderer.renderLostText();
                return;
            }
            if (isWon(hiddenWord)) {
                gameTextRenderer.renderWonText();
                return;
            }
        }
    }

    private boolean isLost(HiddenWord hiddenWord) {
        return hiddenWord.getWrongChars().size() == Constants.ERRORS_TO_LOSE;
    }

    private boolean isWon(HiddenWord hiddenWord) {
        return !hiddenWord.getWordWithMask().contains(Constants.HIDDEN_CHAR_MASK);
    }
}
