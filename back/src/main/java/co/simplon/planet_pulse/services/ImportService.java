package co.simplon.planet_pulse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import co.simplon.planet_pulse.dtos.in.CountryDtoIn;
import co.simplon.planet_pulse.dtos.in.RestCountriesResponse;
import co.simplon.planet_pulse.dtos.out.CountryDtoOut;
import co.simplon.planet_pulse.entities.Countries;
import co.simplon.planet_pulse.entities.Regions;
import co.simplon.planet_pulse.entities.Subregions;
import co.simplon.planet_pulse.repositories.CountryRepository;
import co.simplon.planet_pulse.repositories.RegionRepository;
import co.simplon.planet_pulse.repositories.SubregionRepository;
import tools.jackson.databind.ObjectMapper;

@Service

public class ImportService {

	private final CountryRepository countryRepository;
	private final RegionRepository regionRepository;
	private final SubregionRepository subregionRepository;
	private final RestClient restClient;
	private final ObjectMapper objectMapper;
	// assignation

	public ImportService(CountryRepository countryRepository, RegionRepository regionRepository,
			SubregionRepository subregionRepository, RestClient.Builder restClient, ObjectMapper objectMapper) {
		this.countryRepository = countryRepository;
		this.regionRepository = regionRepository;
		this.subregionRepository = subregionRepository;
		this.restClient = restClient.build();
		this.objectMapper = objectMapper;
	}
	// constructor

	@Value("${api.restcountries.base-url}")
	private String baseUrl;

	@Value("${api.restcountries.fields}")
	private String fields;

	@Value("${api.restcountries.key}")
	private String key;
	// injection de dépendance

	private String buildUrl(int offset) {
		String offsetParam = "";

		if (offset > 0) {
			offsetParam = "&offset=" + offset;
		} else {
			offsetParam = "";
		}
		String buildedUrl = baseUrl + fields + "&limit=100" + offsetParam + "&pretty=1";

		return buildedUrl;
	}
	// Concaténation de l'url

	private String fetchRawJson(String url) {
		return restClient.get().uri(url).header("Authorization", "Bearer " + key).retrieve().body(String.class);
	}

	// Envoi d'une requête get avec l'url construit dans buildUrl() et assigné à url
	// dans importCountries()
	// Add the given, single header value under the given name.
	// Récupèrer la reponse en string.
	private Subregions findOrCreateSubregion(String regionName, String subregionName) {
		String reg = regionName.toLowerCase();
		String sub = subregionName.toLowerCase();

		Regions region = regionRepository.findByRegion(reg).orElseGet(() -> {
			Regions r = new Regions();
			r.setRegion(reg);
			return regionRepository.save(r);
		});

		return subregionRepository.findBySubregion(sub).orElseGet(() -> {
			Subregions s = new Subregions();
			s.setSubregion(sub);
			s.setRegion(region);
			return subregionRepository.save(s);
		});
	}

	private Countries toEntity(CountryDtoIn dto) {
		Countries entity = new Countries();
		entity.setIsoCode(dto.codes().alpha_2());
		entity.setCountry(dto.names().common());
		entity.setUrlFlag(dto.flag().url_svg());
		entity.setPopulation(dto.population());
		entity.setAreaKm(dto.area().kilometers());
		entity.setSubregion(findOrCreateSubregion(dto.region(), dto.subregion()));

		return entity;
	}

	public CountryDtoOut importCountries() {
		
		int imported = 0;
		int [] offsets = {0, 100, 200};
    	for (int offset : offsets) {
    		
    	String url = buildUrl(offset);
        IO.println("Appel URL : " + url);
        
    	try {
    		
    		String response = fetchRawJson(url);
    		
    		RestCountriesResponse parsed = objectMapper.readValue(response, RestCountriesResponse.class);
    		//deserialize: JSON to object
    		
    		
    		List<CountryDtoIn> countries = parsed.data().objects();
            IO.println("Offset " + offset + " - Nombre pays: " + countries.size());
    		// Data structure to store 
    		
    		List<CountryDtoIn> completeCountries = countries.stream()
    				.filter(CountryDtoIn::isComplete)
    				.toList();
            IO.println("Offset " + offset + " - Pays complets: " + completeCountries.size() + "/" + countries.size());
    		//Pipeline 
    	
    		
    		for (CountryDtoIn dto : completeCountries) {
    		    Countries entity = toEntity(dto);
    		    countryRepository.save(entity);
    		    imported++;
    		}

    		} catch (Exception e) {
    		IO.println("Erreur: " + e.getMessage());
    		//
    		}
    	}
    	IO.println("Pays importés : " + imported);
        return new CountryDtoOut(imported);
    }

}