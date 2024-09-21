package com.school.schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Ucionica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv; // Npr. "101", "IT kabinet"

    @Enumerated(EnumType.STRING)
    private TipUcionice tip; // OBIČNA, IT

    private Integer kapacitet;

    @OneToMany(mappedBy = "ucionica", cascade = CascadeType.ALL)
    private List<Termin> termini;
}
