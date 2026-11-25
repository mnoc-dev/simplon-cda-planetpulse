package co.simplon.planet_pulse.services;

import co.simplon.planet_pulse.dtos.in.CreateNoteDto;
import co.simplon.planet_pulse.dtos.out.NoteResponseDto;
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
    public NoteResponseDto createNote(CreateNoteDto createNoteDto) {
        Note note = new Note();
        note.setTitle(createNoteDto.title());
        note.setContent(createNoteDto.content());
        note.setIdCountry(createNoteDto.idCountry());
        if (createNoteDto.dateReport() == null) {
            note.setDateReport(LocalDate.now());
        } else {
            note.setDateReport(createNoteDto.dateReport());
        }
        Note savedNote =  noteRepository.save(note);
        return new NoteResponseDto(
        savedNote.getIdNote(),
        savedNote.getCreationDate(),
        savedNote.getTitle(),
        savedNote.getContent(),
        savedNote.getIdCountry(),
        savedNote.getDateReport()
        );

        }
    }

