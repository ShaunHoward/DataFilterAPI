import java.util.ArrayList;

/**
 * A Gain Filter is a FIR Filter that multiplies only the input by a constant factor,
 * b(0) to get the output.
 *
 * @author Shaun Howard
 */
public class GainFilter extends FIRFilter{

    /**
     * Constructs a scalar linear filter with boundary coefficients M and N
     * and gain multiplier b for output.
     * The list of multipliers for the input, a, are all initialized to 0.
     *
     * @param M - the input boundary coefficient
     * @param N - the output boundary coefficient
     * @param b - the multiplier list for output
     */
    public GainFilter(int M, int N, ArrayList<Double> b) {
        super(M, N, b);
    }
}
