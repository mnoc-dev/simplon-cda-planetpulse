package co.simplon.planet_pulse.dtos;

import java.math.BigDecimal;

public record IndicatorRecord(
        int year,
        BigDecimal forestArea,
        BigDecimal co2Emissions,
        BigDecimal pm25Exposure,
        BigDecimal renewableEnergyShare
        ) {

}
