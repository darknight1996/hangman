package org.example.dialog.impl;

import org.example.validator.CharacterValidatorFactory;

public class LetterDialog extends CharacterDialog {

    public LetterDialog(final String title, final String errorMessage) {
        super(
                title,
                errorMessage,
                new CharacterValidatorFactory().getEngLetterValidator()
        );
    }

}
