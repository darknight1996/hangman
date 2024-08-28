package org.example.mapper;

@FunctionalInterface
public interface Mapper<T, R> {

    R map(final T value);

}
