package io;

import functions.TableFunction;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileLoader {

    public TableFunction loadTableFunction(String filename) throws Exception {
        ArrayList<Double> xValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();

        Scanner scanner = new Scanner(new File(filename));
        scanner.useLocale(Locale.US);

        while (scanner.hasNextDouble()) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();

            xValues.add(x);
            yValues.add(y);
        }

        scanner.close();

        return new TableFunction(xValues, yValues);
    }
}