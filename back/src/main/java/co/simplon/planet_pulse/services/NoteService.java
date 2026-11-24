package co.simplon.planet_pulse.services;

import co.simplon.planet_pulse.dtos.in.CreateNoteDto;
import co.simplon.planet_pulse.entities.Note;
import co.simplon.planet_pulse.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;

    }
    public Note createNote(CreateNoteDto createNoteDto) {
        Note note = new Note();
        note.setTitle(createNoteDto.title());
        note.setContent(createNoteDto.content());
        note.setIdCountry(createNoteDto.idCountry());
        if (createNoteDto.dateReport() == null) {
            note.setDateReport(LocalDate.now());
        } else {
            note.setDateReport(createNoteDto.dateReport());
        }
        return noteRepository.save(note);
        }
    }

