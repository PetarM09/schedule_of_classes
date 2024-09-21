package com.school.schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DanUNedelji danUNedelji; // Ponedeljak, Utorak, itd.

    private String vreme; // Npr. "08:00-09:00"

    @ManyToOne
    @JoinColumn(name = "predmet_id")
    private Predmet predmet;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "odeljenje_id")
    private Odeljenje odeljenje;

    @ManyToOne
    @JoinColumn(name = "ucionica_id")
    private Ucionica ucionica;

    @ManyToOne
    @JoinColumn(name = "raspored_id")
    private Raspored raspored;
}
