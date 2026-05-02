package math;

import functions.Function1D;

public class Differentiator {

    private final double h;

    public Differentiator(double h) {
        this.h = h;
    }

    public double derivative(Function1D f, double x) {
        return (f.value(x + h) - f.value(x - h)) / (2 * h);
    }
}