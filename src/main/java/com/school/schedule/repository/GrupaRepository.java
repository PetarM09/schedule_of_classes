package com.school.schedule.repository;

import com.school.schedule.model.Grupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GrupaRepository extends JpaRepository<Grupa, Long> {
}
