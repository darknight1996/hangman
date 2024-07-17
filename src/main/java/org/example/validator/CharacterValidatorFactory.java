package org.example.validator;

import java.util.function.Predicate;

public class CharacterValidatorFactory {

    public Predicate<Character> getEngLetterValidator() {
        return (inputCharacter) -> (inputCharacter >= 'a' && inputCharacter <= 'z');
    }

    public Predicate<Character> getEmptyValidator() {
        return (inputCharacter) -> true;
    }
}
