package co.simplon.planet_pulse.dtos.in;

public record FlagDto(String url_svg) {
	
	public boolean isComplete() {
		return url_svg != null && url_svg.isBlank();
	}
}
