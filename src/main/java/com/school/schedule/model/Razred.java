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

    @OneToMany(mappedBy = "razred", cascade = CascadeType.ALL)
    private List<Odeljenje> odeljenja;
}
