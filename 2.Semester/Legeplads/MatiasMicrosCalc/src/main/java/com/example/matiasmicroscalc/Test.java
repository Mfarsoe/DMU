package com.example.matiasmicroscalc;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Utils.writeToIFile("ingridienser","test",2.1,2.2,2.3,2.4);

        List<Ingridiens> ing = Utils.readFromFile("ingridienser");

        for (int i = 0; i < ing.size(); i++) {
            System.out.println(ing.get(i));
        }

    }
}
