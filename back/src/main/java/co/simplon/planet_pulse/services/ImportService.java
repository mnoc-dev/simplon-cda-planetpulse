package co.simplon.planet_pulse.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import co.simplon.planet_pulse.dtos.out.CountryDtoOut;
import co.simplon.planet_pulse.repositories.CountryRepository;
import co.simplon.planet_pulse.repositories.RegionRepository;
import co.simplon.planet_pulse.repositories.SubregionRepository;

@Service
public class ImportService {

    private final CountryRepository countryRepository;
    private final RegionRepository regionRepository;
    private final SubregionRepository subregionRepository;
    private final RestClient restClient;

    public ImportService(CountryRepository countryRepository,
                         RegionRepository regionRepository,
                         SubregionRepository subregionRepository,
                         RestClient.Builder restClient) {
        this.countryRepository = countryRepository;
        this.regionRepository = regionRepository;
        this.subregionRepository = subregionRepository;
        this.restClient = restClient.build();
    }

    public CountryDtoOut importCountries() {
        return new CountryDtoOut(0);
    }
}