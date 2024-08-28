package org.example.content;

public class GameContent {

    private static final String YOU_WON_TEXT = "You won!";
    private static final String YOU_LOST_TEXT = "You lost!";
    private static final String ENTER_LETTER_TEXT = "Enter the letter: ";
    private static final String WRONG_LETTERS_TEXT = "Wrong letters: ";
    private static final String HIDDEN_WORD_TEXT = "Hidden word is ";
    private static final String ERRORS_LEFT_TEXT = "Errors left: ";

    private final HangmanContent hangmanContent;

    public GameContent(final HangmanContent hangmanContent) {
        this.hangmanContent = hangmanContent;
    }

    public String getLostText(final int errorsCount, final String hiddenWord) {
        return hangmanContent.getHangman(errorsCount) + "\n" +
            YOU_LOST_TEXT + "\n" +
            getHiddenWordText((hiddenWord));
    }

    public String getWonText(final int errorsCount, final String hiddenWordWithMask) {
        return getHiddenWordText(hiddenWordWithMask) + "\n" +
            hangmanContent.getHangman(errorsCount) + "\n" +
            YOU_WON_TEXT + "\n" +
            getErrorsLeftText(errorsCount);
    }

    public String getGuessCharText(final int errorsCount, final int errorsLeft, final String wrongChars,
                                   final String hiddenWordWithMask) {
        return getHiddenWordText(hiddenWordWithMask) + "\n" +
            hangmanContent.getHangman(errorsCount) + "\n" +
            getErrorsLeftText(errorsLeft) + "\n" +
            WRONG_LETTERS_TEXT + wrongChars + "\n" +
            ENTER_LETTER_TEXT;
    }

    private String getErrorsLeftText(final int errorsLeft) {
        return ERRORS_LEFT_TEXT + errorsLeft;
    }

    private String getHiddenWordText(final String word) {
        return HIDDEN_WORD_TEXT + word;
    }

}
