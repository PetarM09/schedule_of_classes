package com.school.schedule.repository;

import com.school.schedule.model.Razred;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazredRepository extends JpaRepository<Razred, Long> {
    Razred findByNivo(int nivo);
}