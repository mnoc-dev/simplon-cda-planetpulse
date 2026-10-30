package co.simplon.planet_pulse.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.planet_pulse.dtos.ImportView;
import co.simplon.planet_pulse.services.ImportService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/import-countries")
public class ImportController {
	
	private final ImportService service;

    // Injection de dépendance par le constructeur
    public ImportController(ImportService service) {
        this.service = service;
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ImportView importCountries() {
		return service.importCountries();
	}
	

}
