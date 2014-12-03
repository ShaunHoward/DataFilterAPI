package filter;

import java.util.ArrayList;

/**
 * <p>
 * A FIRFilter is a ScalarLinearFilter with one multiplier for output a(0) initialized to zero.
 * This type of filter does not calculate a sum of multiplied output values and has the slope-intercept form.
 * The output boundary coefficient M is thus initialized to zero. All remaining parameters are utilized in construction
 * as if the filter were a ScalarLinearFilter, i.e. the input boundary coefficient and the multiplier list for input
 * calculation in the scalar linear equation.
 * </p>
 * <p>
 * No operations from ScalarLinearFilter are overridden in a FIRFilter, and thus, a FIRFilter behaves like a
 * ScalarLinearFilter.
 * </p>
 *
 * @see filter.ScalarLinearFilter
 *
 * @author Shaun Howard
 */
public class FIRFilter extends ScalarLinearFilter {

    /**
     * Constructs a scalar linear filter with input boundary coefficient N
     * and list of multipliers b for input.
     * The list of multipliers for the output, a, have values initialized to 0
     * after super is called.
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
