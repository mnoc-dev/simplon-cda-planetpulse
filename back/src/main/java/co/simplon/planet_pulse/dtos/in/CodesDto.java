package co.simplon.planet_pulse.dtos.in;

public record CodesDto(String alpha_2) {
	
	public boolean isComplete() {
		return alpha_2 != null && alpha_2.isBlank();
	}
}
