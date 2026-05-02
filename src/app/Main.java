package app;

import io.TreeSetCsvLoader;
import functions.Function1D;
import io.CsvFileLoader;
import io.FileWriterUtil;
import math.Differentiator;

public class Main {

    public static void main(String[] args) throws Exception {

        CsvFileLoader csvFileLoader = new CsvFileLoader();
        FileWriterUtil fileWriter = new FileWriterUtil();
        Differentiator differentiator = new Differentiator(1e-5);

        FunctionProcessor processor = new FunctionProcessor(differentiator, fileWriter);

        Function1D function = new TreeSetCsvLoader().load("data.csv");

        processor.process(
                function,
                1.5,
                2.5,
                0.05,
                "output_csv_treemap_function.txt"
        );

        System.out.println("Done! CSV TreeMap function works.");
    }
}