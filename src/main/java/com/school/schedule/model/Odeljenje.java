package com.school.schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Odeljenje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv; // Npr. "1a", "2b", itd.

    @ManyToOne
    @JoinColumn(name = "razred_id")
    private Razred razred;

    @ManyToOne
    @JoinColumn(name = "smer_id")
    private Smer smer;

    @ManyToMany
    @JoinTable(
            name = "grupa_odeljenje", // Tabela za povezivanje
            joinColumns = @JoinColumn(name = "odeljenje_id"),
            inverseJoinColumns = @JoinColumn(name = "grupa_id")
    )
    private List<Grupa> grupe;

    @ManyToMany(mappedBy = "odeljenja")
    private List<Profesor> profesori;
}

