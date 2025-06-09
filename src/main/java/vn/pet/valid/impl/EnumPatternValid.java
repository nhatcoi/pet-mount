package vn.pet.valid.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vn.pet.valid.EnumPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnumPatternValid implements ConstraintValidator<EnumPattern, Enum<?>> {
    private Pattern pattern;

    @Override
    public void initialize(EnumPattern enumPattern) {
        try {
            pattern = Pattern.compile(enumPattern.regex());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid regex pattern: " + enumPattern.regex(), e);
        }
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        Matcher m = pattern.matcher(value.name());
        return m.matches();
    }
}
