package com.school.schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

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
    private DanUNedelji danUNedelji;

    private String vremeOd; // Npr. "08:00"
    private String vremeDo; // Npr. "12:00"

    private Boolean obavezanPrviCetiriCasovi; // Da li mora imati prva 4 časa svaki dan
}
