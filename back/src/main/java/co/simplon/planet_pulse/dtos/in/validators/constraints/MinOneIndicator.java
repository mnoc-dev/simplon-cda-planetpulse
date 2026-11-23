package co.simplon.planet_pulse.dtos.in.validators.constraints;

import co.simplon.planet_pulse.dtos.in.validators.MinOneIndicatorValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MinOneIndicatorValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MinOneIndicator {
    String message() default "At least one indicator must be provided";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
