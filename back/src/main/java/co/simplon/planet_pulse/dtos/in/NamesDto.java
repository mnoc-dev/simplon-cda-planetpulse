package co.simplon.planet_pulse.dtos.in;

public record NamesDto(String common) {

	public boolean isComplete() {
		return common != null && !common.isBlank();
	}
}
