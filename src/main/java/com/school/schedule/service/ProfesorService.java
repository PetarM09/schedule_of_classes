package com.school.schedule.service;

import com.school.schedule.model.Profesor;
import com.school.schedule.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public Profesor findById(Long id) {
        return profesorRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        profesorRepository.deleteById(id);
    }
}