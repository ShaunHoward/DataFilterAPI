import java.util.ArrayList;

/**
 * A Binomial Filter is a FIR Filter where b(n) = (nCi), where i is the current
 * iteration of the input.
 *
 * @author Shaun Howard
 */
public class BinomialFilter extends FIRFilter {


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
    public BinomialFilter(int N, ArrayList<Double> b) {
        super(N, b);
        setBinomials();
    }

    /**
     * Sets b(i) to N choose i for each b in the list of
     * input multipliers where i ranges from 0 to N.
     */
    private void setBinomials(){
        for (int i = 0; i <= this.getN(); i++){
            double b = fact(getN()) / (fact(i) * fact(getN()-i));
            this.getB().set(i, b);
        }
    }

    /**
     * Calculates the factorial of the input number.
     *
     * @param n - the number to get the factorial of
     * @return the factorial of n
     */
    private int fact(int n){
        if (n == 0){
            return 1;
        }

        return n * fact(n - 1);
    }
}
