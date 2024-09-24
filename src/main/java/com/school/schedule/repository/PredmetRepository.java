package com.school.schedule.repository;

import com.school.schedule.model.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PredmetRepository extends JpaRepository<Predmet, Long> {
    Optional<Predmet> findByNaziv(String naziv);
}