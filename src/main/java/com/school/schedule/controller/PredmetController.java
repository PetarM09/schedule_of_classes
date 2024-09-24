package com.school.schedule.controller;

import com.school.schedule.model.Predmet;
import com.school.schedule.service.PredmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/predmeti")
public class PredmetController {

    @Autowired
    private PredmetService predmetService;

    // Dodavanje ili ažuriranje predmeta
    @PostMapping
    public Predmet createOrUpdatePredmet(@RequestBody Predmet predmet) {
        return predmetService.save(predmet);
    }

    // Preuzimanje predmeta po ID-u
    @GetMapping("/{id}")
    public Optional<Predmet> getPredmetById(@PathVariable Long id) {
        return predmetService.findById(id);
    }

    // Brisanje predmeta po ID-u
    @DeleteMapping("/{id}")
    public void deletePredmet(@PathVariable Long id) {
        predmetService.deleteById(id);
    }

    // Preuzimanje svih predmeta
    @GetMapping
    public List<Predmet> getAllPredmeti() {
        return predmetService.findAll();
    }

    // Preuzimanje predmeta po nazivu
    @GetMapping("/naziv/{naziv}")
    public Optional<Predmet> getPredmetByNaziv(@PathVariable String naziv) {
        return predmetService.findByNaziv(naziv);
    }
}
