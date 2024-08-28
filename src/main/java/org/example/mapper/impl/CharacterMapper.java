package org.example.mapper.impl;

import org.example.mapper.Mapper;

public class CharacterMapper implements Mapper<String, Character> {

    @Override
    public Character map(final String value) {
        if (value.length() != 1) {
            throw new IllegalArgumentException("Input string must have exactly one character");
        }
        return value.toLowerCase().charAt(0);
    }

}
