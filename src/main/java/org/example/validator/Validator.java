package org.example.validator;

public class Validator {

    public boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    public boolean isSingleChar(String s) {
       return s.length() == 1;
    }
}
