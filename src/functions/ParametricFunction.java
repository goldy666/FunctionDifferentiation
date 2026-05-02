package functions;

public class ParametricFunction implements Function1D {

    private double a;

    public ParametricFunction(double a) {
        this.a = a;
    }

    @Override
    public double value(double x) {
        return Math.exp(-a * x * x) * Math.sin(x);
    }
}