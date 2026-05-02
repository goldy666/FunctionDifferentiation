package functions;

import java.util.ArrayList;

public class TableFunction implements Function1D {

    private final ArrayList<Double> xValues;
    private final ArrayList<Double> yValues;

    public TableFunction(ArrayList<Double> xValues, ArrayList<Double> yValues) {
        this.xValues = xValues;
        this.yValues = yValues;
    }

    @Override
    public double value(double x) {

        if (x <= xValues.get(0)) {
            return yValues.get(0);
        }

        if (x >= xValues.get(xValues.size() - 1)) {
            return yValues.get(yValues.size() - 1);
        }

        for (int i = 0; i < xValues.size() - 1; i++) {
            double x1 = xValues.get(i);
            double x2 = xValues.get(i + 1);

            if (x >= x1 && x <= x2) {
                double y1 = yValues.get(i);
                double y2 = yValues.get(i + 1);

                return y1 + (y2 - y1) * (x - x1) / (x2 - x1);
            }
        }

        throw new IllegalArgumentException("Cannot calculate value for x = " + x);
    }
}