package filter;

import exception.IncorrectSizeException;

import java.util.ArrayList;

/**
 * <p>
 * A BinomialFilter is a FIRFilter where each b(i) = (nCi), which is the binomial
 * coefficient at i, where i is the current filter call iteration. There cannot be more than N iterations of
 * filtering performed to achieve unique results. Past N iterations, any calculated results
 * will remain the same as the last affected value of filtering unless reset is called.
 * </p>
 * <p>
 * The setBinomials operation runs in O(nlogn) time. The binomialC operation runs in O(logn) time.
 * The setBinomials method calls the binomialC method to calculate b(i) = (nCi) for each binomial
 * coefficient multiplier in the scalar linear equation. Thus, when a user filters a given value,
 * the value is multiplied by the binomial coefficient at the given iteration of filtering in
 * the scalar linear equation and is added to the previously summed input calculation of the equation.
 * </p>
 * <p>
 * A BinomialFilter does not override any methods from ScalarLinearFilter, and thus, behaves like a
 * ScalarLinearFilter.
 * </p>
 * <p>
 * There is a limitation on the construction values used in a BinomialFilter. The size of the specified
 * list of Doubles, b, at construction time must match the input boundary coefficient N. If this condition
 * is not met, while calculating the binomial coefficients for the scalar linear equation, a checked
 * IncorrectSizeException will be thrown and caught while a message is printed to the standard error stream.
 * This is done to prevent malfunctioned use of the ScalarLinearFilter class.
 * </p>
 *
 * @see filter.FIRFilter
 *
 * @author Shaun Howard
 */
public class BinomialFilter extends FIRFilter {

    /**
     * <p>
     * Constructs a BinomialFilter with input coefficient N
     * and b as a list of double values representing a placeholder list
     * for the binomial coefficients which will be calculated and
     * indexed from 0 to N in this list after
     * calling the FIRFilter constructor.
     * </p>
     * <p>
     * This constructor calls
     * setBinomials() method to setup the binomial coefficient values
     * b(i) = (n C i) indexed by i in the specified list of doubles.
     * N must be equal to the size of the input list for proper operation.
     * </p>
     *
     * @param b - the gain factor of the filter
     */
    public BinomialFilter(int N, ArrayList<Double> b) {
        super(N, b);
        setBinomials();
    }

    /**
     * Sets b(i) to N choose i, where i is a given iteration count, for each b in the collection of
     * input multipliers where i ranges from 0 to N.
     */
    private void setBinomials() {
        try {
            FilterValidator.throwIncorrectSizeException(this.getB(), this.getN());
            for (int i = 0; i < this.getN(); i++){
                double b = binomialC(this.getN(), i);
                this.getB().set(i, b);
            }
        } catch (IncorrectSizeException ise) {
            System.err.println("The binomial list is not the correct size.");
        }

    }

    /**
     * Calculates the binomial coefficient based on the input numbers.
     * Uses a dynamic programming algorithm for efficient logarithmic runtime.
     *
     * @param n - the number to choose from
     * @param i - the number that can be chosen
     * @return the binomial coefficient (n C i)
     */
    private int binomialC(int n, int i){
        if (i == 0){
            return 1;
        }
        return (binomialC(n-1, i-1) * n) / i;
    }
}
