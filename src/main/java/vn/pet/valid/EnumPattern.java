package vn.pet.valid;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import vn.pet.valid.impl.EnumPatternValid;

import static java.lang.annotation.ElementType.*;

@Documented
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumPatternValid.class)
public @interface EnumPattern {
    String name();
    String regex();
    String message() default "{name} must match regex {regex}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
