package co.simplon.planet_pulse.dtos.in.validators.constraints;

import co.simplon.planet_pulse.dtos.in.validators.FutureYearValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FutureYearValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FutureYear {
    String message() default "Year must be superior to current year";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
