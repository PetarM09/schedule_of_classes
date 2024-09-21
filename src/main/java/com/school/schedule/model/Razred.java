package com.school.schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Razred {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer nivo; // 1, 2, 3, 4

    @ManyToOne
    @JoinColumn(name = "smer_id")
    private Smer smer;

    @OneToMany(mappedBy = "razred", cascade = CascadeType.ALL)
    private List<Odeljenje> odeljenja;

    @OneToMany(mappedBy = "razred", cascade = CascadeType.ALL)
    private List<Predmet> predmeti;
}
