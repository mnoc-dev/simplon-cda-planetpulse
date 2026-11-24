package co.simplon.planet_pulse.services;

import co.simplon.planet_pulse.dtos.in.TargetEdit;
import co.simplon.planet_pulse.entities.Country;
import co.simplon.planet_pulse.entities.Target;
import co.simplon.planet_pulse.repositories.CountryRepository;
import co.simplon.planet_pulse.repositories.TargetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TargetService {

    private final TargetRepository targetRepository;
    private final CountryRepository countryRepository;

    public TargetService(TargetRepository targetRepository, CountryRepository countryRepository) {
        this.targetRepository = targetRepository;
        this.countryRepository = countryRepository;
    }

    @Transactional
    public void post(TargetEdit targetInputs){

        Country country = countryRepository.findById(targetInputs.countryId()).orElseThrow();
        // TODO: handle exception in case country is not found

        Target target = new Target();
        target.setCountry(country);
        target.setYear(targetInputs.targetYear());
        target.setCo2Emissions(targetInputs.co2Emissions());
        target.setForestArea(targetInputs.forestArea());
        target.setPm25Exposure(targetInputs.pm25Exposure());
        target.setRenewableEnergyShare(targetInputs.renewableEnergyShare());

        // TODO: handle exception for a country associated to targets with the same year
        targetRepository.save(target);
    }
}
