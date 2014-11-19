package filter;

import exception.NullValueException;

/**
 * Min Filter that filters the data for the minimum value
 * since initialization or the last reset.
 *
 * @author Shaun Howard
 */
public class MinFilter<A extends Comparable<A>,B> implements Filter<A , B>, Resettable<A> {

    // The minimum value found thus far.
    private A min;

    /**
     * Filters the minimum input value since the filter was initialized or
     * was last reset.
     *
     * @param value - the value to filter
     * @return the minimum seen by the filter thus far as type B
     * @throws exception.NullValueException - thrown when the input value is null
     */
    @Override
    public B filter(A value) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(value);
        if (min == null || value.compareTo(min) < 0) {
            min = value;
        }
        try {
            return (B)min;
        } catch (ClassCastException cce){
            System.err.println("Cannot cast properly with typing of MinFilter.");
            return null;
        }
    }

    /**
     * Resets the filter with the specified value.
     *
     * @param value - the value to reset the filter with
     * @throws exception.NullValueException - thrown when the input value is null
     */
    @Override
    public void reset(A value) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(value);
        this.min = value;
    }

    /**
     * Gets the minimum value seen thus far.
     *
     * @return the min value seen thus far
     */
    public A getMin(){
        return this.min;
    }
}