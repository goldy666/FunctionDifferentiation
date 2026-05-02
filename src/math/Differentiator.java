package math;

import functions.Function1D;

public class Differentiator {

    public static double derivative(Function1D f, double x, double h) {
        return (f.value(x + h) - f.value(x - h)) / (2 * h);
    }
}