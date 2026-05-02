package io;

import functions.TreeMapTableFunction;

import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

public class CsvFileLoader {

    public TreeMapTableFunction loadTreeMapFunction(String filename) throws Exception {
        TreeMap<Double, Double> values = new TreeMap<>();

        Scanner scanner = new Scanner(new File(filename));

        if (scanner.hasNextLine()) {
            scanner.nextLine(); // пропускаем заголовок x,y
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.trim().isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");

            double x = Double.parseDouble(parts[0].trim());
            double y = Double.parseDouble(parts[1].trim());

            values.put(x, y);
        }

        scanner.close();

        return new TreeMapTableFunction(values);
    }
}