package org.example.dialog.impl;

import org.example.dialog.Dialog;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class AbstractDialog<T> implements Dialog<T> {

    private final String title;
    private final String errorMessage;
    private final Function<String, T> mapper;
    private final Predicate<T> validator;

    public AbstractDialog(final String title, final String errorMessage, final Function<String, T> mapper,
                          final Predicate<T> validator) {
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
                final T input = mapper.apply(inputString);
                if (validator.test(input)) {
                    return input;
                } else {
                    System.err.println(errorMessage);
                }
            } catch (IllegalArgumentException e) {
                System.err.println(errorMessage);
            }
        }
    }
}
