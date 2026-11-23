package co.simplon.planet_pulse.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import co.simplon.planet_pulse.entities.Countries;

public interface CountryRepository extends JpaRepository<Countries, Long> {
	// Spring auto generation ahead of time
	//Crud methods inherited by JpaRepository
    Optional<Countries> findByIsoCode(String isoCode);
}
