package co.simplon.planet_pulse.repositories;

import co.simplon.planet_pulse.entities.Target;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TargetRepository extends JpaRepository <Target, Long> {
}
