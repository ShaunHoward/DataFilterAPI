package filter;

import exception.NullValueException;

/**
 * Max Filter that filters the data for the maximum value
 * since initialization or the last reset.
 *
 * @author Shaun Howard
 */
public class MaxFilter<A extends Comparable<A>,B> implements Filter<A , B>, Resettable<A> {

    // The maximum value found thus far.
    private A max;

    /**
     * Filters the maximum input value since the filter was initialized or
     * was last reset.
     *
     * @param value - the value to filter
     * @return the maximum seen by the filter thus far as type B
     * @throws exception.NullValueException - thrown when the input value is null
     */
    @Override
    public B filter(A value) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(value);
        if (max == null || value.compareTo(max) > 0) {
            max = value;
        }
        try {
            return (B)max;
        } catch (ClassCastException cce){
            System.err.println("Cannot cast properly with typing of MaxFilter.");
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
        this.max = value;
    }
}
