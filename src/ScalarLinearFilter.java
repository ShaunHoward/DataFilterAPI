import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Scalar Linear Filter that filters input based on a linear equation
 * and previous inputs. The filter can be reset with a given value.
 *
 * @author Shaun Howard
 */
public class ScalarLinearFilter implements ScalarFilter{

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
    private List<Double> input;

    // The previous output list.
    private List<Double> output;

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
        input = new ArrayList<>(Collections.nCopies(M, 0.0));
        output = new ArrayList<>(Collections.nCopies(N, 0.0));
    }

    @Override
    public double filter(double value) {
        //check null
        input.add(value);
        double out = sumInput() - sumOutput();
        output.add(out);
        return out;
    }

    /**
     * Calculates the right side of the linear equation.
     *
     * @return the sum of the input side of the linear equation
     */
    private double sumInput() {
        //check that

        inputSum




    }

    /**
     * Calculates the left side of the linear equation without adding the
     * output, yi, of the current iteration i.
     *
     * @return the left side of the linear equation without the output included
     */
    private double sumOutput() {

    }

    @Override
    public void reset(double r) {
        i = 0;
    }

}
