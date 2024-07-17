package org.example.dialog.impl;

import org.example.mapper.CharacterMapperFactory;
import org.example.validator.CharacterValidatorFactory;

import java.util.function.Predicate;

public class CharacterDialog extends AbstractDialog<Character> {

    public CharacterDialog(final String title, final String errorMessage) {
        this(
                title,
                errorMessage,
                new CharacterValidatorFactory().getEmptyValidator()
        );
    }

    protected CharacterDialog(final String title, final String errorMessage, final Predicate<Character> validator) {
        super(
                title,
                errorMessage,
                new CharacterMapperFactory().getMapper(),
                validator
        );
    }

}
