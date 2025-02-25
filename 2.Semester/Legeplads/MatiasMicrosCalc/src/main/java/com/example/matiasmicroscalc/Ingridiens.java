package com.example.matiasmicroscalc;


public class Ingridiens {
    private String name;
    private double protein;
    private double carb;
    private double fat;
    private double kcal;

    public Ingridiens(String name, double protein, double carb, double fat, double kcal) {
        this.name = name;
        this.protein = protein;
        this.carb = carb;
        this.fat = fat;
        this.kcal = kcal;
    }

    public String getName() {
        return name;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarb() {
        return carb;
    }

    public double getFat() {
        return fat;
    }

    public double getKcal() {
        return kcal;
    }

    @Override
    public String toString() {
        return "Name=" + name + " Protein=" + protein + " Carbs=" + carb + " Fat=" + fat + " Kcal=" + kcal;
    }
}