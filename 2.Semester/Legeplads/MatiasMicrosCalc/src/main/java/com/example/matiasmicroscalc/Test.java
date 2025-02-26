package com.example.matiasmicroscalc;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Utils.writeToIFile("ingridienser","matiasTest",12.3,43.3,12.1,0.01);

        List<Ingridiens> ing = Utils.readFromFile("ingridienser");

        for (int i = 0; i < ing.size(); i++) {
            System.out.println(ing.get(i));
        }

    }
}
