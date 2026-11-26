package co.simplon.planet_pulse.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.planet_pulse.dtos.CountryListItem;
import co.simplon.planet_pulse.services.CountryService;

@RestController
@RequestMapping("/api/countries")
public class CountryListController {

    private final CountryService countryService;

    // Inject the country service.
    public CountryListController(CountryService countryService) {
        this.countryService = countryService;
    }

    // Return all countries for GET /api/countries.
    @GetMapping
    public List<CountryListItem> getAllCountries() {
        return countryService.getAllCountries();
    }
}
