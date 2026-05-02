package functions;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTableFunction implements Function1D {

    private final TreeMap<Double, Double> values;

    public TreeMapTableFunction(TreeMap<Double, Double> values) {
        this.values = values;
    }

    @Override
    public double value(double x) {

        Map.Entry<Double, Double> left = values.floorEntry(x);
        Map.Entry<Double, Double> right = values.ceilingEntry(x);

        if (left == null) {
            return values.firstEntry().getValue();
        }

        if (right == null) {
            return values.lastEntry().getValue();
        }

        double x1 = left.getKey();
        double y1 = left.getValue();

        double x2 = right.getKey();
        double y2 = right.getValue();

        if (x1 == x2) {
            return y1;
        }

        return y1 + (y2 - y1) * (x - x1) / (x2 - x1);
    }
}