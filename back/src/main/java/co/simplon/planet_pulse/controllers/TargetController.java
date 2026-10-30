package co.simplon.planet_pulse.controllers;

import co.simplon.planet_pulse.dtos.in.TargetEdit;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/targets")
public class TargetController {

    @PostMapping
    public String post(@RequestBody @Valid TargetEdit inputs){
        return inputs.toString();
    }
}
