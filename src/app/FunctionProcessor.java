package app;

import functions.Function1D;
import io.FileWriterUtil;
import math.Differentiator;

public class FunctionProcessor {

    private final Differentiator differentiator;
    private final FileWriterUtil fileWriter;

    public FunctionProcessor(Differentiator differentiator, FileWriterUtil fileWriter) {
        this.differentiator = differentiator;
        this.fileWriter = fileWriter;
    }

    public void process(Function1D function, double start, double end, double step, String outputFile) throws Exception {
        StringBuilder sb = new StringBuilder();

        for (double x = start; x <= end; x += step) {
            double y = function.value(x);
            double dy = differentiator.derivative(function, x);

            sb.append(x)
                    .append(" ")
                    .append(y)
                    .append(" ")
                    .append(dy)
                    .append("\n");
        }

        fileWriter.write(outputFile, sb.toString());
    }
}