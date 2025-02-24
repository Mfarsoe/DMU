package com.example.matiasmicroscalc;


public class Ingridiens {
    private String name;
    private double protein;
    private double carbs;
    private double fat;
    private double kcal;

    public Ingridiens(String name, double protein, double carbs, double fat, double kcal) {
        this.name = name;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.kcal = kcal;
    }

    public String getName() {
        return name;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getFat() {
        return fat;
    }

    public double getKcal() {
        return kcal;
    }

    @Override
    public String toString() {
        return name;
    }
}