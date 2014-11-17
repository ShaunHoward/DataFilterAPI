import java.util.ArrayList;

/**
 * A Binomial Filter is a FIR Filter where b(i) = (nCi), which is the binomial
 * coefficient at i, where i is the current iteration of the input.
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
            double b = binomialC(this.getN(), i);
            this.getB().set(i, b);
        }
    }

    /**
     * Calculates the binomial coefficient based on the input numbers.
     *
     * @param n - the number to choose from
     * @param i - the number that can be chosen
     * @return the binomial coefficient n C i
     */
    private int binomialC(int n, int i){
        if (i == 0 || i == n){
            return 1;
        }
        return binomialC(n-1, i-1) + binomialC(n-1, i);
    }
}
