import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ScalarLinearFilter which is a ScalarFilter that filters input based on a linear
 * equation (y(i) + a(1)y(i-1)+...+a(M)y(i-M) = b(0)x(i)+...+b(N)x(i-N)) which
 * considers the current iteration of input, previous input values and the current
 * input value. The filter can be reset with a given double value.
 *
 * @author Shaun Howard
 */
public class ScalarLinearFilter implements ScalarFilter {

    // The output boundary coefficient for the linear equation.
    private int M;

    // The input boundary coefficient for the linear equation.
    private int N;

    // The current iteration of the filter.
    private int i;

    // The sum of the input.
    private double inputSum;

    // The sum of the output.
    private double outputSum;

    // The output multiplier list.
    private List<Double> a;

    // The input multiplier list.
    private List<Double> b;

    // The previous input list.
    private List<Double> x;

    // The previous output list.
    private List<Double> y;

    /**
     * Constructs a scalar linear filter with boundary coefficients N and M
     * and lists of multipliers a and b for input and output consecutively.
     *
     * @param M - the output boundary coefficient
     * @param N - the input boundary coefficient
     * @param a - the multiplier list for output
     * @param b - the multiplier list for input
     */
    public ScalarLinearFilter(int M, int N, ArrayList<Double> a, ArrayList<Double> b){
        this.M = M;
        this.N = N;
        this.a = a;
        this.b = b;
        this.i = 0;
        this.inputSum = 0;
        this.outputSum = 0;
        x = new ArrayList<>(Collections.nCopies(M, 0.0));
        y = new ArrayList<>(Collections.nCopies(N, 0.0));
    }

    /**
     * Filters the input by calculating the output at
     * the current iteration given the linear equation
     * for the scalar linear filter.
     *
     * @param in - the input value to calculate the output in
     *           relation to
     * @return the output value y(i) of the linear equation solution
     */
    @Override
    public Double filter(Double in) {
        //check null
        x.add(i, in);
        double out = sumInput() - sumOutput();
        y.add(i, out);
        i++;
        return out;
    }

    @Override
    public void reset() {
        //not implemented
    }

    /**
     * Calculates the right (input) side of the linear equation.
     * Sum of b(n) * x(i-n), where n starts at 0 and ends at N
     * and i is the current iteration of filter input.
     *
     * @return the sum of the input side of the linear equation
     */
    private double sumInput() {
        //check that b and x are not empty.
        //check that b has n elements

        double sum = 0;
        IN_SUM_LOOP:
        for (int n = 0; n <= N; n++){
            //sum = sum + b(n) * x(i-n)
            if ((i - n) >= 0) {
                sum += b.get(n) * x.get(i - n);
            } else {
                //will only add zeroes to sum, so break
                break IN_SUM_LOOP;
            }
        }

        return sum + inputSum;
    }

    /**
     * Calculates the left (output) side of the linear equation without adding the
     * output, y(i), of the current iteration i.
     * Sum of a(m) * y(i-m), where m starts at 1 and ends at M.
     *
     * @return the left side of the linear equation without the output included
     */
    private double sumOutput() {
        //check that a and y are not empty.
        //check that a has m elements

        double sum = 0;
        OUT_SUM_LOOP:
        for (int m = 1; m <= M; m++){
            //sum = sum + a(m) * y(i-m)
            if ((i - m) >= 0) {
                sum += a.get(m) * y.get(i - m);
            } else {
                //will only add zeroes to sum, so break
                break OUT_SUM_LOOP;
            }
        }

        return sum + outputSum;
    }

    /**
     * Resets the filter with the given value r.
     * Sets the record of previous input value to r.
     * Sets the record of previous output value to
     * r(sum of b(0)-b(N)) / (1 + sum of a(1) - a(M)).
     *
     * @param r - the value to reset the filter with
     */
    @Override
    public void reset(Double r) {
        double dividend = 0;
        double quotient = 1;
        for (int n = 0; n <= N; n++){
            dividend += b.get(n);
        }
        for (int m = 1; m <= M; m++){
            quotient += a.get(m);
        }

        i = 0;
        inputSum = r;
        dividend = r * dividend;
        outputSum = dividend / quotient;
    }

    /**
     * Gets the input boundary coefficient.
     *
     * @return the input boundary coefficient
     */
    public int getN() {
        return N;
    }

    /**
     * Gets the list of input multipliers.
     *
     * @return the list of input multipliers
     */
    public List<Double> getB() {
        return b;
    }

}
