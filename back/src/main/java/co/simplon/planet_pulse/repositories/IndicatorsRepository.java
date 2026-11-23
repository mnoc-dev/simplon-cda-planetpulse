package co.simplon.planet_pulse.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.simplon.planet_pulse.dtos.IndicatorsView;


@Repository
public interface IndicatorsRepository extends JpaRepository<Indicators, long> {
		// TODO Auto-generated method stub
		Optional<IndicatorsView> findProjectedById(Long id);
	}

}
