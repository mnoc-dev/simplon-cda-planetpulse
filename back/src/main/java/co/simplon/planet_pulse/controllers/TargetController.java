package co.simplon.planet_pulse.controllers;

import co.simplon.planet_pulse.dtos.in.TargetEdit;
import co.simplon.planet_pulse.entities.Target;
import co.simplon.planet_pulse.services.TargetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/targets")
public class TargetController {

    private TargetService targetService;

    public TargetController(TargetService targetService) {
        this.targetService = targetService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody @Valid TargetEdit inputs){
        targetService.post(inputs);
    }
}
