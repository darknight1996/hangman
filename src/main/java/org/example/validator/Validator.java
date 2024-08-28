package org.example.validator;

@FunctionalInterface
public interface Validator<T> {

    boolean validate(final T value);

}
