package com.school.schedule.controller;

import com.school.schedule.model.Profesor;
import com.school.schedule.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesori")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public List<Profesor> getAllProfesori() {
        return profesorService.findAll();
    }

    @GetMapping("/{id}")
    public Profesor getProfesorById(@PathVariable Long id) {
        return profesorService.findById(id);
    }

    @PostMapping
    public Profesor createProfesor(@RequestBody Profesor profesor) {
        return profesorService.save(profesor);
    }

    @DeleteMapping("/{id}")
    public void deleteProfesor(@PathVariable Long id) {
        profesorService.deleteById(id);
    }
}