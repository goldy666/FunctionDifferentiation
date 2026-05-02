package functions;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTableFunction implements Function1D {

    private final TreeSet<double[]> values;

    public TreeSetTableFunction(TreeSet<double[]> values) {
        this.values = values;
    }

    @Override
    public double value(double x) {

        double[] left = null;
        double[] right = null;

        for (double[] pair : values) {
            if (pair[0] <= x) {
                left = pair;
            }
            if (pair[0] >= x) {
                right = pair;
                break;
            }
        }

        if (left == null) return values.first()[1];
        if (right == null) return values.last()[1];

        double x1 = left[0];
        double y1 = left[1];

        double x2 = right[0];
        double y2 = right[1];

        if (x1 == x2) return y1;

        return y1 + (y2 - y1) * (x - x1) / (x2 - x1);
    }
}