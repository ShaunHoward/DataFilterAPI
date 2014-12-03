package filter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A Gain Filter is a FIR Filter that multiplies only the input by a constant factor,
 * b(0), to get the filtered output.
 *
 * @see filter.FIRFilter
 *
 * @author Shaun Howard
 */
public class GainFilter extends FIRFilter {

    /**
     * Constructs a FIR Filter with input coefficient as 1
     * and b(0) as the gain factor, the only factor in the list.
     *
     * @param b - the gain factor of the filter
     */
    public GainFilter(double b) {
        super(1, new ArrayList<Double>(Arrays.asList(b)));
    }
}
