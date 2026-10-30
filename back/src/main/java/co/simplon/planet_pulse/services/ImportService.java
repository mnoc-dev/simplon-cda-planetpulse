package co.simplon.planet_pulse.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import co.simplon.planet_pulse.repositories.CountryRepository;
import co.simplon.planet_pulse.repositories.RegionRepository;
import co.simplon.planet_pulse.repositories.SubregionRepository;

import co.simplon.planet_pulse.dtos.ImportView;

@Service
public class ImportService {

	private final CountryRepository countryRepository;
	private final RegionRepository regionRepository;
	private final SubregionRepository subregionRepository;
	private final RestClient restClient;

	@Value("${api.restcountries.base-url}")
	private String baseUrl;

	@Value("${api.restcountries.fields}")
	private String fields;

	@Value("${api.restcountries.key}")
	private String apiKey;

	public ImportService(CountryRepository countryRepository, RegionRepository regionRepository,
			SubregionRepository subregionRepository, RestClient.Builder restClient) {
		
		super();
		this.countryRepository = countryRepository;
		this.regionRepository = regionRepository;
		this.subregionRepository = subregionRepository;
		this.restClient = restClient.build();
	}

	public ImportView importCountries() {

		if (countryRepository.count() > 0) {
			
			int[] offsets = {0, 100,200};
			
			for (int offset : offsets) {
				String url = buildUrl(offset);
				System.out.println("Appel de l'URL : " + url);
				
				try {
					
					String response = restClient.get()
							.uri(url)
							.header("Authorization", "Bearer" + apiKey)
							.retrieve()
							.body(String.class);
			        System.out.println("Réponse reçue de l'offset " + offset + " (début) : " + response.substring(0, 100));
			        
				} catch (Exception e) {
					System.out.println("Erreur pour l'offset" + offset + ":" + e.getMessage());
				}
			}
			throw new RuntimeException("Import already done.");
		}
		return new ImportView(0, "not yet imp");
	}

	private String buildUrl(int offset) {

		String offsetParam = (offset > 0) ? "&offset=" + offset : "";
		return baseUrl + fields + "&limit=100" + offsetParam + "&pretty=1";
	}
}
