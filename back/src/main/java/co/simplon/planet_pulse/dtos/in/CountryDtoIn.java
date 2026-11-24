package co.simplon.planet_pulse.dtos.in;

public record CountryDtoIn(NameDto names, CodeDto codes, FlagDto flag, String region, String subregion, AreaDto kilometers, Long population) {

	// immutable
	// auto generated constructor and accessor
	// names in params must match with JSON names
}
