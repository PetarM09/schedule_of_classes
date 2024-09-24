package com.school.schedule.controller;

import com.school.schedule.model.Odeljenje;
import com.school.schedule.service.OdeljenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/odeljenja")
public class OdeljenjeController {

    @Autowired
    private OdeljenjeService odeljenjeService;

    // Postojeće metode...

    // Preuzimanje odeljenja po razredu i nazivu (npr. "1" za razred, "a" za odeljenje)
    @GetMapping("/razred/{razred}/naziv/{naziv}")
    public Optional<Odeljenje> getOdeljenjeByRazredAndNaziv(@PathVariable int razred, @PathVariable String naziv) {
        return odeljenjeService.findByRazredAndOdeljenje(razred, naziv);
    }
}
