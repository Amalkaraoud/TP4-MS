package com.exemple.historique.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Operation {
    private Integer id;      // Utilisation de Integer au lieu de int
    private String operateur;
    private int a;
    private int b;
    private Double resultat; // Utilisation de Double au lieu de double
}