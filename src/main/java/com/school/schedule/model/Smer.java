package com.school.schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Smer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv; // Npr. "Prirodno-matematički", "Društveno-jezički", itd.

    @OneToMany(mappedBy = "smer", cascade = CascadeType.ALL)
    private List<Razred> razredi;
}

