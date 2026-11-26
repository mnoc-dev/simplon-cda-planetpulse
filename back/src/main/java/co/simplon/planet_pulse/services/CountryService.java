package co.simplon.planet_pulse.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.planet_pulse.dtos.CountryListItem;
import co.simplon.planet_pulse.repositories.CountryListRepository;

@Service
public class CountryService {

    private final CountryListRepository countryRepository;

    // Inject the country repository.
    public CountryService(CountryListRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    // Get all countries from the repository.
    public List<CountryListItem> getAllCountries() {
        return countryRepository.findAllForList();
    }
}
