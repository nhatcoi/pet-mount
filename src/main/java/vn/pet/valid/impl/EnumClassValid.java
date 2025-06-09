package vn.pet.valid.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vn.pet.valid.EnumClass;

import java.util.List;
import java.util.stream.Stream;

public class EnumClassValid implements ConstraintValidator<EnumClass, CharSequence> {
    private List<?> acceptedValues;

    @Override
    public void initialize(EnumClass constraintAnnotation) {
        acceptedValues = Stream.of(constraintAnnotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .toList();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        if (charSequence == null || charSequence.isEmpty()) {
            return true;
        }
        return acceptedValues.contains(charSequence.toString().toUpperCase());
    }
}
