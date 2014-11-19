package filter;

import exception.NullValueException;

/**
 * Max Filter N is a max filter that returns the maximum of the
 * last N values seen or the maximum value seen since the last
 * reset if less than N values were encountered.
 *
 * @author Shaun Howard
 */
public class MaxFilterN<A extends Comparable<A>,B> extends FilterN<A> implements Filter<A,B>, Resettable<A> {

    /**
     * Constructs a Max Filter that resets after N
     * values are filtered.
     *
     * @param n - the number of calls to reset
     *          the filter at
     */
    public MaxFilterN(int n){
        super(n);
    }

    /**
     * Filters the input value by returning the maximum
     * value input of the last N inputs or since the
     * last reset.
     * @param value - the value to filter
     * @return the maximum value yet seen by the filter
     * @throws exception.NullValueException - thrown when the input value is null
     */
    @Override
    public B filter(A value) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(value);
        maintainN();
        getValues().add(value);
        return max();
    }

    /**
     * Resets the filter with the given value.
     *
     * @param value - the value to reset the filter with
     * @throws exception.NullValueException - thrown when the input value is null
     */
    public void reset(A value) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(value);
        getValues().clear();
        getValues().add(value);
    }

    /**
     * Returns the maximum element in the list of values.
     *
     * @return the max element in the list of values
     */
    private B max(){
        A max = null;
        boolean first = true;
        for (A value : getValues()){
            if (first){
                first = false;
                max = value;
            }
            if (value.compareTo(max) > 0){
                max = value;
            }
        }
        return (B)max;
    }
}
