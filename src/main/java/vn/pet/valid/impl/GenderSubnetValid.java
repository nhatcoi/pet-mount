package vn.pet.valid.impl;

import vn.pet.util.Gender;
import vn.pet.valid.EnumGender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

public class GenderSubnetValid implements ConstraintValidator<EnumGender,Enum<?>> {

    private Gender[] genders;

    @Override
    public void initialize(EnumGender constraintAnnotation) {
        this.genders = constraintAnnotation.anyOf();
    }

    @Override
    public boolean isValid(Enum<?> anEnum, ConstraintValidatorContext constraintValidatorContext) {
        List<Gender> genderList = Arrays.asList(genders);
        return anEnum == null
                || CollectionUtils.isEmpty(genderList)
                || genderList.contains(anEnum);
    }
}
