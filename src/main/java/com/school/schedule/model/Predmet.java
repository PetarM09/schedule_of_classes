package com.school.schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Predmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

    private Integer brojTeorijskihCasova;
    private Integer brojVezbiCasova;

    @Enumerated(EnumType.STRING)
    private TipVezbi tipVezbi; // CELO_ODELJENJE, POLOVINA_ODELJENJA, GRUPA_PREDMETA

    @ManyToOne
    @JoinColumn(name = "smer_id")
    private Smer smer;

    @ManyToOne
    @JoinColumn(name = "razred_id")
    private Razred razred;

    @ManyToMany
    @JoinTable(
            name = "predmet_profesor",
            joinColumns = @JoinColumn(name = "predmet_id"),
            inverseJoinColumns = @JoinColumn(name = "profesor_id"))
    private List<Profesor> profesori;
}