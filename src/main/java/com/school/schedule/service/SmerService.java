package com.school.schedule.service;

import com.school.schedule.model.Razred;
import com.school.schedule.model.Smer;
import com.school.schedule.repository.SmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmerService {
    @Autowired
    private SmerRepository smerRepository;

    @Autowired
    private RazredService razredService;

    public Smer save(Smer smer) {
        return smerRepository.save(smer);
    }

    public Smer findByNaziv(String naziv) {
        return smerRepository.findByNaziv(naziv);
    }

    public void createDefaultSmerovi() {
        String[] smeroviNazivi = {
                "Prirodno-matematički",
                "Opšti",
                "Sportski",
                "Društveno-jezički",
                "IT"
        };

        for (String naziv : smeroviNazivi) {
            Smer smer = new Smer();
            smer.setNaziv(naziv);
            save(smer);
            // Kreiraj razrede za svaki smer
            Razred razred = new Razred();
            razredService.createRazrediForSmer(smer);
        }
    }
}