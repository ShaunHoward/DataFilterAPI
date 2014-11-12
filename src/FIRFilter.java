import java.util.ArrayList;
import java.util.Collections;

/**
 * A FIR Filter is a Scalar Linear Filter with a(1-m) = 0.
 *
 * @author Shaun Howard
 */
public class FIRFilter extends ScalarLinearFilter{

    /**
     * Constructs a scalar linear filter with boundary coefficients M and N
     * and list of multipliers b for output.
     * The list of multipliers for the input, a, are all initialized to 0.
     *
     * @param M - the input boundary coefficient
     * @param N - the output boundary coefficient
     * @param b - the multiplier list for output
     */
    public FIRFilter(int M, int N, ArrayList<Double> b) {
        super(M, N, new ArrayList<>(Collections.nCopies(M, 0.0)), b);
    }
}
