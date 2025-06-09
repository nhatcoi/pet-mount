package vn.pet.valid.impl;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vn.pet.valid.PhoneNumber;

public class PhoneValidator implements ConstraintValidator<PhoneNumber, String> {

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(phoneNumber)) {
            return false;
        }

        // valid phone number of format
        if (phoneNumber.matches("\\d{10}")) return true;

        // valid phone number with -, . or spaces
        if (phoneNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;

        // validating phone number with extension length from 3 to 5
        if (phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;

        // validating phone number where area code is in braces ()
        if (phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;

        return false;

    }
}
