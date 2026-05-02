package io;

import functions.TableFunction;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileLoader {

    public static TableFunction loadTableFunction(String filename) throws Exception {
        ArrayList<Double> xValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();

        File file = new File(filename);
        System.out.println("Reading file: " + file.getAbsolutePath());
        System.out.println("File exists: " + file.exists());

        Scanner scanner = new Scanner(file);
        scanner.useLocale(Locale.US);

        while (scanner.hasNextDouble()) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();

            xValues.add(x);
            yValues.add(y);
        }

        scanner.close();

        System.out.println("Loaded points: " + xValues.size());

        return new TableFunction(xValues, yValues);
    }
}