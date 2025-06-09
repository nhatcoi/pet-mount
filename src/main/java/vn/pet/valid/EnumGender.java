package vn.pet.valid;

import vn.pet.util.Gender;
import vn.pet.valid.impl.GenderSubnetValid;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Documented
@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = GenderSubnetValid.class)
public @interface EnumGender {
    String name();
    Gender[] anyOf();
    String message() default "{name} must be any of enum {anyOf}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
