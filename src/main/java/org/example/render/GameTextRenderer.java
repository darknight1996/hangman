package org.example.render;

import org.example.constants.Constants;
import org.example.model.HiddenWord;

public class GameTextRenderer {

    private final HiddenWord hiddenWord;
    private final HangmanRenderer hangmanRenderer;

    public GameTextRenderer(HiddenWord hiddenWord, HangmanRenderer hangmanRenderer) {
        this.hiddenWord = hiddenWord;
        this.hangmanRenderer = hangmanRenderer;
    }

    public void renderLostText() {
        hangmanRenderer.render();
        System.out.println(Constants.YOU_LOST_TEXT);
        System.out.println(Constants.HIDDEN_WORD_TEXT + hiddenWord.getWord());
    }

    public void renderWonText() {
        System.out.println(Constants.HIDDEN_WORD_TEXT + hiddenWord.getWordWithMask());
        hangmanRenderer.render();
        System.out.println(Constants.YOU_WON_TEXT);
        System.out.println(Constants.ERRORS_LEFT_TEXT + (Constants.ERRORS_TO_LOSE - hiddenWord.getErrorsCount()));
    }

    public void renderGuessCharText() {
        System.out.println(Constants.HIDDEN_WORD_TEXT + hiddenWord.getWordWithMask());
        hangmanRenderer.render();
        System.out.println(Constants.ERRORS_LEFT_TEXT + (Constants.ERRORS_TO_LOSE - hiddenWord.getErrorsCount()));
        System.out.println(Constants.WRONG_LETTERS_TEXT + hiddenWord.getWrongChars());
        System.out.println(Constants.ENTER_LETTER_TEXT);
    }

    public void renderInvalidCharText() {
        System.out.println(Constants.INVALID_CHARACTER_TEXT);
    }

    public void renderInvalidInputStringText() {
        System.out.println(Constants.INVALID_INPUT_STRING_TEXT);
    }
}
