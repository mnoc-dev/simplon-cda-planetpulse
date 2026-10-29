package co.simplon.planet_pulse.services;

import co.simplon.planet_pulse.dtos.IndicatorsEdit;
import co.simplon.planet_pulse.dtos.IndicatorsView;
import co.simplon.planet_pulse.entities.Indicators;
import co.simplon.planet_pulse.repositories.IndicatorsRepository;

public class IndicatorsService {
	
	private final IndicatorsRepository repository;
	
	public IndicatorsService(IndicatorsRepository repository) {
		this.repository = repository;
	}
	
	public IndicatorsService get(Long id) {
		return null;
	}
	
	public IndicatorsView post(IndicatorsEdit inputs) {
		Indicators indicators = new Indicators();
		
		
		
		
	}

	

}
