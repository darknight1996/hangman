package org.example.dialog.impl;

import org.example.constants.Constants;

public class LetterDialog extends CharDialog {

    public LetterDialog(String title) {
        super(title);
    }

    @Override
    public Character input() {
        while (true) {
            final char inputChar = super.input();
            if (validator.isLetter(inputChar)) {
                return inputChar;
            } else {
                System.out.println(Constants.INVALID_CHARACTER_TEXT);
            }
        }
    }
}
