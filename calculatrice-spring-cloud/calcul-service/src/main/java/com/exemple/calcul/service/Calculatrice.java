package com.exemple.calcul.service;

import org.springframework.stereotype.Service;

@Service
public class Calculatrice {

    public int somme(int a, int b) {
        return a + b;
    }

    public int soustraction(int a, int b) {
        return a - b;
    }

    public int produit(int a, int b) {
        return a * b;
    }

    public double division(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division par 0 impossible");
        }
        return (double) a / b;
    }
}