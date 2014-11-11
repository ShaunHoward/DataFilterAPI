/**
 * Min Filter that filters the data for the minimum value
 * since initialization or the last reset.
 *
 * @author Shaun Howard
 */
public class MinFilter<A extends Comparable<A>,B> implements Filter<A , B>{

    // The minimum value found thus far.
    private A min;

    /**
     * Filters the minimum input value since the filter was initialized or
     * was last reset.
     *
     * @param value - the value to filter
     * @return the minimum seen by the filter thus far as type B
     */
    public B filter(A value) {
        //Check null

        if (value.compareTo(min) < 0) {
            min = value;
        }
        return (B)min;
    }

    /**
     * Resets the filter with the specified value.
     *
     * @param value - the value to reset the filter with
     */
    public void reset(A value){
        this.min = value;
    }
}