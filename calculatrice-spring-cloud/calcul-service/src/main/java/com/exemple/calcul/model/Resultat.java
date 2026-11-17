package com.exemple.calcul.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Resultat {
    private String operation;
    private int a;
    private int b;
    private double resultat;
}