package co.simplon.planet_pulse.controllers;

import co.simplon.planet_pulse.dtos.in.CreateNoteDto;
import co.simplon.planet_pulse.dtos.out.NoteResponseDto;
import co.simplon.planet_pulse.services.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notes")
@Tag(name = "Notes", description = "Note management")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }
    @Operation(
            summary = "Create a note",
            description = "Creates a new monitoring note associated with a country."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Note created successfully"
    )
    @PostMapping
    public ResponseEntity<NoteResponseDto> createNote(@RequestBody @Valid CreateNoteDto createNoteDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(noteService.createNote(createNoteDto));
    }
}



