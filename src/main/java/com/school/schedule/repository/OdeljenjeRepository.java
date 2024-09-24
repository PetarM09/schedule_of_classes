package com.school.schedule.repository;

import com.school.schedule.model.Odeljenje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OdeljenjeRepository extends JpaRepository<Odeljenje, Long> {

    // Postojeća metoda za pronalaženje po nazivu
    Optional<Odeljenje> findByNaziv(String naziv);

    // Nova metoda za pronalaženje po razredu i nazivu odeljenja
    @Query("SELECT o FROM Odeljenje o WHERE o.razred.nivo = :razred AND o.naziv = :naziv")
    Optional<Odeljenje> findByRazredAndOdeljenje(@Param("razred") int razred, @Param("naziv") String naziv);
}
