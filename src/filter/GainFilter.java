package filter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>
 * A GainFilter is a FIR Filter that multiplies only the input by a constant factor,
 * b(0), in the scalar linear equation to filter output.
 * The input boundary coefficient of a GainFilter is 1 by default because only
 * one input parameter is operated on within the FIRFilter's scalar linear equation.
 * </p>
 * <p>
 * A GainFilter is constructed with a double-precision floating point value. The super
 * constructor is called with the specified value as a list for implementation purposes.
 * </p>
 * <p>
 * A GainFilter does not override any methods of ScalarLinearFilter, and thus, a GainFilter behaves
 * like a ScalarLinearFilter.
 * </p>
 *
 * @see filter.FIRFilter
 *
 * @author Shaun Howard
 */
public class GainFilter extends FIRFilter {

    /**
     * Constructs a GainFilter with input coefficient N as 1
     * and b as a list with b(0) representing the specified gain factor
     * by calling the FIRFilter constructor.
     *
     * @param b - the gain factor of the filter
     */
    public GainFilter(double b) {
        super(1, new ArrayList<Double>(Arrays.asList(b)));
    }
}
