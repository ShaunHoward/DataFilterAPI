/**
 * Max Filter that filters the data for the maximum value
 * since initialization or the last reset.
 *
 * @author Shaun Howard
 */
public class MaxFilter<A extends Comparable<A>,B> implements Filter<A , B>{

    // The maximum value found thus far.
    private A max;

    /**
     * Filters the maximum input value since the filter was initialized or
     * was last reset.
     *
     * @param value - the value to filter
     * @return the maximum seen by the filter thus far as type B
     */
    public B filter(A value) {
        //Check null

        if (value.compareTo(max) > 0) {
            max = value;
        }
        return (B)max;
    }
}
