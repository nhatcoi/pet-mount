package vn.pet.valid;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import vn.pet.valid.impl.EnumClassValid;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE})
@Constraint(validatedBy = EnumClassValid.class)
public @interface EnumClass {
    String name();
    String message() default "{name} must be any of enum{enumClass}";
    Class<? extends Enum<?>> enumClass();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
