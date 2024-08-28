package org.example.validator.impl;

import org.example.validator.Validator;

public class EngLetterValidator implements Validator<Character> {

    @Override
    public boolean validate(final Character value) {
        return value >= 'a' && value <= 'z';
    }

}
