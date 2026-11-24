package co.simplon.planet_pulse.controllers;

import co.simplon.planet_pulse.dtos.in.CreateNoteDto;
import co.simplon.planet_pulse.entities.Note;
import co.simplon.planet_pulse.services.NoteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }
    @PostMapping
    public Note createNote(@RequestBody @Valid CreateNoteDto createNoteDto) {
        return noteService.createNote(createNoteDto);
    }
}



