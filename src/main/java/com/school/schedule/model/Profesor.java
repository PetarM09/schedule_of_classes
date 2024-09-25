package com.school.schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;
    private String prezime;

    @ManyToMany(mappedBy = "profesori")
    private List<Predmet> predmeti = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "profesor_odeljenje",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "odeljenje_id"))
    private List<Odeljenje> odeljenja;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Dostupnost> dostupnosti;
}