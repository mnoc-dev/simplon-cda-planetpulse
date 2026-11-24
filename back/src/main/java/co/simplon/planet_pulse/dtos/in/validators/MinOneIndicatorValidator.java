package co.simplon.planet_pulse.dtos.in.validators;

import co.simplon.planet_pulse.dtos.in.TargetEdit;
import co.simplon.planet_pulse.dtos.in.validators.constraints.MinOneIndicator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MinOneIndicatorValidator implements ConstraintValidator<MinOneIndicator, TargetEdit> {

    @Override
    public void initialize(MinOneIndicator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TargetEdit value, ConstraintValidatorContext context) {
        if(value.co2Emissions() == null && value.forestArea() == null && value.pm25Exposure() == null && value.renewableEnergyShare() == null ){
            return false;
        }
        return true;
    }
}
