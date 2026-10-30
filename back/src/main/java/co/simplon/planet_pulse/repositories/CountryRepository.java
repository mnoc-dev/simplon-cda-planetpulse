package co.simplon.planet_pulse.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import co.simplon.planet_pulse.entities.Countries;

public interface CountryRepository extends JpaRepository<Countries, Long> {
    Optional<Countries> findByIsoCode(String isoCode);
}
