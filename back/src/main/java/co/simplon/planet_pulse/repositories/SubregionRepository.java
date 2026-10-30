package co.simplon.planet_pulse.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.planet_pulse.entities.Subregions;

public interface SubregionRepository extends JpaRepository<Subregions, Long>{
	Optional<Subregions> findBySubregion(String subregion);
}
