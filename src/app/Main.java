package app;

import functions.Function1D;
import io.FileLoader;
import io.FileWriterUtil;
import math.Differentiator;

public class Main {

    public static void main(String[] args) throws Exception {

        Function1D f = FileLoader.loadTableFunction("C:\\Users\\ilja5\\IdeaProjects\\FunctionDifferentiation\\data.txt");

        double h = 1e-5;

        StringBuilder sb = new StringBuilder();

        for (double x = 1.5; x <= 6.5; x += 0.05) {
            double y = f.value(x);
            double dy = Differentiator.derivative(f, x, h);

            sb.append(x).append(" ")
                    .append(y).append(" ")
                    .append(dy).append("\n");
        }

        FileWriterUtil.write("output_table_function.txt", sb.toString());

        System.out.println("Done! Results saved to output_table_function.txt");
    }
}