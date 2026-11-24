package co.simplon.planet_pulse.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    		IO.println("Réponse brute (début) : " + response.substring(0, 2000));
    	} catch (Exception e) {
    		IO.println("Erreur: " + e.getMessage());
    	}
        return new CountryDtoOut(0);
    }


}