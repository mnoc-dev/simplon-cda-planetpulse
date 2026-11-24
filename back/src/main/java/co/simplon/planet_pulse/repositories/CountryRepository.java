package co.simplon.planet_pulse.repositories;

import co.simplon.planet_pulse.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository <Country, Long> {
}
