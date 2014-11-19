package filter;

import exception.NullValueException;

import java.util.ArrayList;
import java.util.List;

/**
 * A Filter N abstract class that only considers the last N values input
 * to the filter. The filter can be reset with a given value of type A.
 *
 * @author Shaun Howard
 */
public abstract class FilterN<A extends Comparable<A>> {

    // The count to reset the filter at.
    private int n = 0;

    // An array of stored input values.
    private List<A> values;

    /**
     * Constructs a new Filter N that tracks n
     * previous inputs for filtering.
     *
     * @param n - the number of previous inputs tracked
     */
    public FilterN(int n){
        //check null

        this.n = n;
        values = new ArrayList<>();
    }

    /**
     * Removes the front node of the list if
     * the size of the list is greater than or equal to
     * n.
     * @throws exception.NullValueException - thrown when the value n is null
     */
    void maintainN() throws NullValueException {
        FilterValidator.throwExceptionWhenNull(new Integer(n));
        if (values.size() >= n) {
            values.remove(0);
        }
    }

    /**
     * Resets the filter with the given value.
     *
     * @param value - the value to reset the filter with
     * @throws exception.NullValueException - thrown when the input value is null
     */
    public void reset(A value) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(value);
        values.clear();
        values.add(value);
    }

    /**
     * Gets the list of values collected by this filter.
     *
     * @return the list of values collected by this filter
     */
    public List<A> getValues() {
        return values;
    }

    /**
     * Gets the count of values to accept.
     *
     * @return the count of values to accept
     * @throws exception.NullValueException - thrown when n is null
     */
    public int getN() throws NullValueException {
        FilterValidator.throwExceptionWhenNull(new Integer(n));
        return this.n;
    }
}
