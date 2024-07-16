package org.example.content;

import org.example.constants.Constants;
import org.example.model.HiddenWord;

public class GameContent {

    private final HangmanContent hangmanContent;

    public GameContent(HangmanContent hangmanContent) {
        this.hangmanContent = hangmanContent;
    }

    public String getLostText(final int errorsCount, final String hiddenWord) {
        return hangmanContent.getHangman(errorsCount) + "\n" +
            Constants.YOU_LOST_TEXT + "\n" +
            getHiddenWordText((hiddenWord));
    }

    public String getWonText(final int errorsCount, final String hiddenWordWithMask) {
        return getHiddenWordText(hiddenWordWithMask) + "\n" +
            hangmanContent.getHangman(errorsCount) + "\n" +
            Constants.YOU_WON_TEXT + "\n" +
            getErrorsLeftText(errorsCount);
    }

    public String getGuessCharText(final int errorsCount, String wrongChars, final String hiddenWordWithMask) {
        return getHiddenWordText(hiddenWordWithMask) + "\n" +
            hangmanContent.getHangman(errorsCount) + "\n" +
            getErrorsLeftText(errorsCount) + "\n" +
            Constants.WRONG_LETTERS_TEXT + wrongChars + "\n" +
            Constants.ENTER_LETTER_TEXT;
    }

    private String getErrorsLeftText(final int errorsCount) {
        return Constants.ERRORS_LEFT_TEXT + (Constants.ERRORS_TO_LOSE - errorsCount);
    }

    private String getHiddenWordText(final String word) {
        return Constants.HIDDEN_WORD_TEXT + word;
    }
}
