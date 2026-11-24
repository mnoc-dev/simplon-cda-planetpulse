package co.simplon.planet_pulse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import co.simplon.planet_pulse.dtos.in.CountryDtoIn;
import co.simplon.planet_pulse.dtos.in.RestCountriesResponse;
import co.simplon.planet_pulse.dtos.out.CountryDtoOut;
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

    public ImportService(CountryRepository countryRepository,
                         RegionRepository regionRepository,
                         SubregionRepository subregionRepository,
                         RestClient.Builder restClient,
                         ObjectMapper objectMapper) {
        this.countryRepository = countryRepository;
        this.regionRepository = regionRepository;
        this.subregionRepository = subregionRepository;
        this.restClient = restClient.build();
        this.objectMapper = objectMapper;
    }

    @Value("${api.restcountries.base-url}")
    private String baseUrl;
    
    @Value("${api.restcountries.fields}")
    private String fields;
    
    @Value("${api.restcountries.key}")
    private String key;
    
    
    private String buildUrl(int offset) {
    	String offsetParam = "";
    	String buildedUrl = baseUrl + fields + "&limit=100" + offsetParam + "&pretty=1";
    	if(offset > 0) {
    		offsetParam = "&offset=" + offset;
    	}else {
    		offsetParam = "";
    	}
    	return buildedUrl;
    }
    
    private String fetchRawJson(String url) {
    	return restClient.get()
    			.uri(url)
    			.header("Authorization", "Bearer " + key)
    			.retrieve()
    			.body(String.class);
    }
    
    public CountryDtoOut importCountries() {
    	String url = buildUrl(0);
        IO.println("Appel URL : " + url);
        
    	try {
    		
    		String response = fetchRawJson(url);
    		
    		RestCountriesResponse parsed = objectMapper.readValue(response, RestCountriesResponse.class);
    		//deserialize
    		
    		List<CountryDtoIn> countries = parsed.data().objects();
    		IO.println("Nombre pays: " + countries.size());
    		
    		if(!countries.isEmpty()) {
    			IO.println("Premier pays" + countries.get(0));
    		}

    	} catch (Exception e) {
    		IO.println("Erreur: " + e.getMessage());
    	}
        return new CountryDtoOut(0);
    }


}