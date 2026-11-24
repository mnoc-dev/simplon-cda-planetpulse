package co.simplon.planet_pulse.repositories;

import co.simplon.planet_pulse.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
