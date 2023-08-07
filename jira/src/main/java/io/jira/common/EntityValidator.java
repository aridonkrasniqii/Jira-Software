package io.jira.common;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import java.util.Set;

public class EntityValidator {

    @Inject
    static Validator validator;

    public static <T> Uni<T> validate(T entity, Class<T> clazz) {
        Set<ConstraintViolation<T>> violations = validator.validate(entity, clazz);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        return Uni.createFrom().item(entity);
    }


    public static <T> Uni<T> validateEntity(T entity) {
        Set<ConstraintViolation<T>> violations = validator.validate(entity);

        if(!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        return Uni.createFrom().item(entity);
    }


}
