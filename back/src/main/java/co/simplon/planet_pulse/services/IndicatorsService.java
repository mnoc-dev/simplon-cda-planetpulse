package co.simplon.planet_pulse.services;

import co.simplon.planet_pulse.dtos.IndicatorsEdit;
import co.simplon.planet_pulse.dtos.IndicatorsView;
import co.simplon.planet_pulse.entities.Indicators;
import co.simplon.planet_pulse.repositories.IndicatorsRepository;
import co.simplon.planet_pulse.repositories.repository;

public class IndicatorsService {
	
	private final IndicatorsRepository repository;
	
	public IndicatorsService(IndicatorsRepository repository) {
		this.repository= repository;
	}
	
	public IndicatorsView get(Long id) {
		return repository.findProjectedById(id).orElseThrow();
	}

	public IndicatorsView post(IndicatorsEdit inputs) {
		Indicators indicators = new Indicators();
		
		return null;
	}
	


	

}
