package com.school.schedule.service;

import com.school.schedule.model.Razred;
import com.school.schedule.model.Smer;
import com.school.schedule.repository.RazredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RazredService {
    @Autowired
    private RazredRepository razredRepository;

    public Razred save(Razred razred) {
        return razredRepository.save(razred);
    }

    public Razred findByNivo(int nivo){
        return razredRepository.findByNivo(nivo);
    }

    public void createRazrediForSmer(Smer smer) {
        for (int i = 1; i <= 4; i++) { // 1 do 4
            Razred razred = new Razred();
            razred.setNivo(i);
            save(razred);
        }
    }
}