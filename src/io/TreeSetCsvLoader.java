package io;

import functions.TreeSetTableFunction;

import java.io.File;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetCsvLoader {

    public TreeSetTableFunction load(String filename) throws Exception {

        TreeSet<double[]> values = new TreeSet<>(Comparator.comparingDouble(a -> a[0]));

        Scanner scanner = new Scanner(new File(filename));

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(",");

            double x = Double.parseDouble(parts[0]);
            double y = Double.parseDouble(parts[1]);

            values.add(new double[]{x, y});
        }

        scanner.close();

        return new TreeSetTableFunction(values);
    }
}