package filter;

import exception.NullValueException;

/**
 * Min Filter N is a min filter that returns the minimum of the
 * last N values seen or the minimum value seen since the last
 * reset if less than N values were encountered.
 *
 * @author Shaun Howard
 */
public class MinFilterN<A extends Comparable<A>,B> extends FilterN<A> implements Filter<A,B> {

    /**
     * Constructs a Min Filter that resets after N
     * values are filtered.
     *
     * @param n - the number of calls to reset
     *          the filter at
     */
    public MinFilterN(int n){
        super(n);
    }

    /**
     * Filters the input value by returning the minimum
     * value input of the last N inputs or since the
     * last reset.
     * @param value - the value to filter
     * @return the minimum value yet seen by the filter
     * @throws exception.NullValueException - thrown when the input value is null
     */
    @Override
    public B filter(A value) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(value);
        maintainN();
        getValues().add(value);
        return min();
    }

    /**
     * Returns the minimum element in the list of values.
     *
     * @return the min element in the list of values
     */
    private B min(){
        A min = null;
        boolean first = true;
        for (A value : getValues()){
            if (first){
                first = false;
                min = value;
            }
            if (value.compareTo(min) < 0){
                min = value;
            }
        }
        return (B)min;
    }

}
