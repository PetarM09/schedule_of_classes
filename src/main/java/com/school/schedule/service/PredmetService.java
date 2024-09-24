package com.school.schedule.service;

import com.school.schedule.model.Predmet;
import com.school.schedule.repository.PredmetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PredmetService {

    @Autowired
    private PredmetRepository predmetRepository;

    // Kreiranje ili ažuriranje predmeta
    public Predmet save(Predmet predmet) {
        return predmetRepository.save(predmet);
    }

    // Pronalaženje predmeta po ID-u
    public Optional<Predmet> findById(Long id) {
        return predmetRepository.findById(id);
    }

    // Brisanje predmeta po ID-u
    public void deleteById(Long id) {
        predmetRepository.deleteById(id);
    }

    // Pronalaženje svih predmeta
    public List<Predmet> findAll() {
        return predmetRepository.findAll();
    }

    // Pronalaženje predmeta po nazivu
    public Optional<Predmet> findByNaziv(String naziv) {
        return predmetRepository.findByNaziv(naziv);
    }
}

