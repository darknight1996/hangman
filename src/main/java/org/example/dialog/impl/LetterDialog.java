package org.example.dialog.impl;

import org.example.validator.impl.EngLetterValidator;

public class LetterDialog extends CharacterDialog {

    public LetterDialog(final String title, final String errorMessage) {
        super(title, errorMessage, new EngLetterValidator());
    }

}
