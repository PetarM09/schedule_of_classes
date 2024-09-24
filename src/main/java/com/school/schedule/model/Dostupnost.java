package com.school.schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Dostupnost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @Enumerated(EnumType.STRING)
    private List<DanUNedelji> daniUNedelji; // Npr. "Dani u nedelji kada profesor ne radi"

    private Long casOd; // Npr. "1"
    private Long casDo; // Npr. "5"
}
