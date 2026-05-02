package functions;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.License;

public class StringFunction implements Function1D {

    private final Argument x;
    private final Expression expression;

    public StringFunction(String expr) {
        License.iConfirmNonCommercialUse("Student project");

        x = new Argument("x");
        expression = new Expression(expr, x);
    }

    @Override
    public double value(double value) {
        x.setArgumentValue(value);
        return expression.calculate();
    }
}