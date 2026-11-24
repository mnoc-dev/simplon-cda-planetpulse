package co.simplon.planet_pulse.dtos.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateNoteDto(
        @NotBlank(message="title must not be blank" )
        @Size(max = 255)
        String title,

        @NotBlank(message = "content must not be blank")
        @Size(max = 10000)
        String content,

        @NotNull(message = "idCountry must not be null")
        @Positive(message = "idCountry must be positive")
        Integer idCountry,

        LocalDate dateReport

) {

}
