package org.example.dialog.impl;

import org.example.mapper.impl.CharacterMapper;
import org.example.validator.Validator;

public class CharacterDialog extends AbstractDialog<Character> {

    public CharacterDialog(final String title, final String errorMessage) {
        this(title, errorMessage, (value -> true));
    }

    protected CharacterDialog(final String title, final String errorMessage, final Validator<Character> validator) {
        super(title, errorMessage, new CharacterMapper(), validator);
    }

}
