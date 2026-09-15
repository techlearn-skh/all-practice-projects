package com.skh.propertycustomvalidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class CustomStringValidator
        implements ConstraintValidator<CustomStringConstraint, String> {

    private static final List<String> NOT_ALLOWED_VALUES =
            List.of("null", "undefined");

    @Override
    public boolean isValid(
            String value,
            ConstraintValidatorContext context) {

        return value != null
                && !NOT_ALLOWED_VALUES.contains(value.trim());
    }
}