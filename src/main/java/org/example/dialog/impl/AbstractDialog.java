package org.example.dialog.impl;

import org.example.dialog.Dialog;
import org.example.mapper.Mapper;
import org.example.validator.Validator;

import java.util.Scanner;

public abstract class AbstractDialog<T> implements Dialog<T> {

    private final String title;
    private final String errorMessage;
    private final Mapper<String, T> mapper;
    private final Validator<T> validator;

    public AbstractDialog(final String title, final String errorMessage, final Mapper<String, T> mapper,
                          final Validator<T> validator) {
        this.title = title;
        this.errorMessage = errorMessage;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public T input() {
        while (true) {
            System.out.println(title);

            final Scanner scanner = new Scanner(System.in);
            final String inputString = scanner.nextLine();

            try {
                final T input = mapper.map(inputString);
                if (validator.validate(input)) {
                    return input;
                } else {
                    System.err.println(errorMessage);
                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
