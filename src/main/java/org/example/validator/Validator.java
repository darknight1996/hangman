package org.example.validator;

public class Validator {

    public boolean isValidChar(char c) {
        return Character.isLetter(c);
    }

    public boolean isSingleLetter(String s) {
       return s.length() == 1;
    }
}
