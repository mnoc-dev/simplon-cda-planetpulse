package co.simplon.planet_pulse.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import co.simplon.planet_pulse.dtos.out.CountryDtoOut;
import co.simplon.planet_pulse.services.ImportService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@CrossOrigin(origins = "http://localhost:5500")
@RequestMapping("/api/import-countries")
public class ImportController {
	
	private final ImportService service;

    // Dependencies injection
    public ImportController(ImportService service) {
        this.service = service;
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CountryDtoOut importCountries() {
		return service.importCountries();
	}
	

}
