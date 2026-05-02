package functions;

public class AnalyticalFunction implements Function1D {

    @Override
    public double value(double x) {
        return Math.exp(-x * x) * Math.sin(x);
    }
}