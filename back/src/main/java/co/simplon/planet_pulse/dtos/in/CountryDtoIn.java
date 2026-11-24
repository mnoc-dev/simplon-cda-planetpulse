package co.simplon.planet_pulse.dtos.in;

public record CountryDtoIn(String isoCode, String commonName, String flagUrl, Long population, Double area, String region, String subregion) {

	//immutable
	//auto generated constructor and accessor
	//names in params must match with JSON names
}
