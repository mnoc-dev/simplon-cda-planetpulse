package co.simplon.planet_pulse.dtos.out;

import java.time.Instant;
import java.time.LocalDate;

public record NoteResponseDto(
        Integer idNote,
        Instant creationDate,
        String title,
        String content,
        Integer idCountry,
        LocalDate dateReport
) {
}
