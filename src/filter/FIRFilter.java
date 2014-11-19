package filter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A FIR Filter is a Scalar Linear Filter with a(0,1) = 0
 * and M initialized to 0. Summation of the output is ignored
 * in a FIR Filter.
 *
 * @author Shaun Howard
 */
public class FIRFilter extends ScalarLinearFilter {

    /**
     * Constructs a scalar linear filter with input boundary coefficient N
     * and list of multipliers b for input.
     * The list of multipliers for the output, a, are all initialized to 0.
     * The boundary coefficient for the output, M, is set to 0 since summation
     * of output does not take place in a FIR filter.
     *
     * @param N - the input boundary coefficient
     * @param b - the multiplier list for input
     */
    public FIRFilter(int N, ArrayList<Double> b) {
        super(0, N, new ArrayList<Double>(), b);
    }
}
