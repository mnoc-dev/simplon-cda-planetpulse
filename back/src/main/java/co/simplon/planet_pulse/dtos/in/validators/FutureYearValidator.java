package co.simplon.planet_pulse.dtos.in.validators;

import co.simplon.planet_pulse.dtos.in.validators.constraints.FutureYear;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;


public class FutureYearValidator implements ConstraintValidator<FutureYear, Integer> {
    @Override
    public void initialize(FutureYear constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer targetYear, ConstraintValidatorContext context) {
        return targetYear > LocalDate.now().getYear();
    }
}
