package com.example.matiasmicroscalc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void writeToIFile(String filename,
                                    String name,
                                    double protein,
                                    double carb,
                                    double fedt,
                                    double kcal) {
        String filepath = (filename + ".txt");
        try {
            FileWriter myWriter = new FileWriter(filepath, true);
            myWriter.write(name + "," + protein + "," + carb + "," + fedt + "," + kcal + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static List<Ingridiens> readFromFile(String filename) {
        String filepath = "" + filename + ".txt";
        List<Ingridiens> ingriList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {  // Læser linjen korrekt i løkken
                String[] tokens = line.split(",");
                if (tokens.length == 5) {
                    String name = tokens[0];
                    double protein = Double.parseDouble(tokens[1]);
                    double carb = Double.parseDouble(tokens[2]);
                    double fedt = Double.parseDouble(tokens[3]);
                    double kcal = Double.parseDouble(tokens[4]);
                    ingriList.add(new Ingridiens(name, protein, carb, fedt, kcal));
                }
            }
        } catch (IOException e) {
            System.out.println("Fejl ved læsning af fil: " + e.getMessage());
        }

        return ingriList;
    }


    //udskrive til samlet udskrift fil


}
