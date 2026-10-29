package co.simplon.planet_pulse.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.simplon.planet_pulse.dtos.IndicatorsEdit;
import co.simplon.planet_pulse.dtos.IndicatorsView;
import co.simplon.planet_pulse.services.IndicatorsService;

@RequestMapping("/indicators")
public class IndicatorsController {

	private final IndicatorsService service;

	public IndicatorsController(IndicatorsService service) {
		this.service = service;e
	}

	@GetMapping("/{id}")

	public IndicatorsView get(@PathVariable long id) {
		return service.get(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public IndicatorsView post(@RequestBody IndicatorsEdit inputs) {
		return service.post(inputs);
	}

}
