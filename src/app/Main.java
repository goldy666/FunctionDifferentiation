package app;

import functions.Function1D;
import io.FileLoader;
import io.FileWriterUtil;
import math.Differentiator;

public class Main {

    public static void main(String[] args) throws Exception {

        FileLoader fileLoader = new FileLoader();
        FileWriterUtil fileWriter = new FileWriterUtil();
        Differentiator differentiator = new Differentiator(1e-5);

        FunctionProcessor processor = new FunctionProcessor(differentiator, fileWriter);

        Function1D function = fileLoader.loadTableFunction("data.txt");

        processor.process(
                function,
                1.5,
                6.5,
                0.05,
                "output_table_function.txt"
        );

        System.out.println("Done! Refactored version works.");
    }
}