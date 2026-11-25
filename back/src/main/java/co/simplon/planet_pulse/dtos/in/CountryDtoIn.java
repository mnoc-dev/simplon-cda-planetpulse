package co.simplon.planet_pulse.dtos.in;

public record CountryDtoIn(NamesDto names, CodesDto codes, FlagDto flag, String region, String subregion, AreaDto area, Long population) {

	// immutable
	// auto generated constructor and accessor
	// names in params must match with JSON names
	
	public boolean isComplete() {
		return names != null && names.isComplete()
				
				&& codes != null && codes.isComplete()
				
				&& flag != null && flag.isComplete()
				
				&& region != null && !region.isBlank()
				
				&& subregion != null && !subregion.isBlank()
				
				&& area != null && area.kilometers() != null
				
				&& population != null;
		
	}
}
