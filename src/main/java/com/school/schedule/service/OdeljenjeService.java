package com.school.schedule.service;

import com.school.schedule.model.Odeljenje;
import com.school.schedule.repository.OdeljenjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdeljenjeService {

    @Autowired
    private OdeljenjeRepository odeljenjeRepository;

    // Kreiranje ili ažuriranje odeljenja
    public Odeljenje save(Odeljenje odeljenje) {
        return odeljenjeRepository.save(odeljenje);
    }

    // Pronalaženje odeljenja po ID-u
    public Optional<Odeljenje> findById(Long id) {
        return odeljenjeRepository.findById(id);
    }

    // Brisanje odeljenja po ID-u
    public void deleteById(Long id) {
        odeljenjeRepository.deleteById(id);
    }

    // Pronalaženje svih odeljenja
    public List<Odeljenje> findAll() {
        return odeljenjeRepository.findAll();
    }

    // Pronalaženje odeljenja po razredu i odeljenju (npr. "1a")
    public Optional<Odeljenje> findByNaziv(String naziv) {
        return odeljenjeRepository.findByNaziv(naziv);
    }

    // Nova metoda za pronalaženje po razredu i odeljenju (npr. "3-1")
    public Optional<Odeljenje> findByRazredAndOdeljenje(int razred, String naziv) {
        return odeljenjeRepository.findByRazredAndOdeljenje(razred, naziv);
    }
}
