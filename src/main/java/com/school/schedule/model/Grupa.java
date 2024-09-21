package com.school.schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Grupa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Veza ka više odeljenja
    @ManyToMany(mappedBy = "grupe")
    private List<Odeljenje> odeljenja;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "predmet_id")
    private Predmet predmet;

    private Integer brojCasova; // Koliko časova grupa ima nedeljno
}
