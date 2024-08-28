package org.example.validator.impl;

import org.example.validator.Validator;

public class EngLetterValidator implements Validator<Character> {

    @Override
    public boolean validate(final Character character) {
        final char lowerCaseCharacter = Character.toLowerCase(character);
        return lowerCaseCharacter >= 'a' && lowerCaseCharacter <= 'z';
    }

}
