package org.example.mapper;

import java.util.function.Function;

public class CharacterMapperFactory {

    public Function<String, Character> getMapper() {
        return (inputString) -> {
            if (inputString.length() != 1) {
                throw new IllegalArgumentException();
            } else {
                return inputString.toLowerCase().charAt(0);
            }
        };
    }
}
