import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Scalar Linear Filter that filters input based on a linear equation
 * and previous inputs. The filter can be reset with a given value.
 *
 * @author Shaun Howard
 */
public class ScalarLinearFilter implements ScalarFilter {

    // The input boundary coefficient for the linear equation.
    private int M;

    // The output boundary coefficient for the linear equation.
    private int N;

    // The current iteration of the filter.
    private int i;

    // The sum of the input.
    private double inputSum;

    // The sum of the output.
    private double outputSum;

    // The input multiplier list.
    private List<Double> a;

    // The output multiplier list.
    private List<Double> b;

    // The previous input list.
    private List<Double> x;

    // The previous output list.
    private List<Double> y;

    /**
     * Constructs a scalar linear filter with boundary coefficients M and N
     * and lists of multipliers a and b for input and output consecutively.
     *
     * @param M - the input boundary coefficient
     * @param N - the output boundary coefficient
     * @param a - the multiplier list for input
     * @param b - the multiplier list for output
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

    @Override
    public double filter(double in) {
        //check null
        x.add(i, in);
        double out = sumInput() - sumOutput();
        y.add(i, out);
        i++;
        return out;
    }

    /**
     * Calculates the right side of the linear equation.
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
     * Calculates the left side of the linear equation without adding the
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
     * @param r
     */
    @Override
    public void reset(double r) {
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

}
