package com.school.schedule.repository;

import com.school.schedule.model.Smer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmerRepository extends JpaRepository<Smer, Long> {
    Smer findByNaziv(String naziv);
}