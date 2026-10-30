package co.simplon.planet_pulse.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.planet_pulse.entities.Regions;

public interface RegionRepository extends JpaRepository<Regions, Long>{
	
    Optional<Regions> findByRegion(String region);
}
