package org.example.Domain;

public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}
