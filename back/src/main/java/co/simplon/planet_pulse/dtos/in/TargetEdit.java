package co.simplon.planet_pulse.dtos.in;

import co.simplon.planet_pulse.dtos.in.validators.constraints.FutureYear;
import jakarta.validation.constraints.*;

public record TargetEdit (

    @NotNull
    @Positive
    Integer countryId,

    @NotNull
    @FutureYear
    Integer targetYear,

    @DecimalMin("0.01")
    @Digits(integer = 10, fraction = 2)
    Double c02Emissions,

    @DecimalMin("0.01")
    @DecimalMax("100.00")
    @Digits(integer = 3, fraction = 2)
    Double forestArea,

    @DecimalMin("0.01")
    @Digits(integer = 3, fraction = 2)
    Double pm25Exposure,

    @DecimalMin("0.01")
    @DecimalMax("100.00")
    @Digits(integer = 3, fraction = 2)
    Double renewableEnergyShare

){

}
