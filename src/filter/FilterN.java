package filter;

import exception.EmptyListException;
import exception.IncorrectSizeException;
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
        this.n = n;
        values = new ArrayList<>();
    }

    /**
     * Removes the front node of the list if
     * the size of the list is greater than or equal to
     * n.
     * @throws exception.EmptyListException - thrown when values list is empty
     * @throws exception.IncorrectSizeException - thrown when n is negative
     */
    public void maintainN() throws EmptyListException, IncorrectSizeException {
        if (values.size() >= getN()) {
            FilterValidator.throwExceptionWhenEmpty(values);
            values.remove(0);
        }
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
     * @throws exception.IncorrectSizeException - thrown when n is negative
     */
    public int getN() throws IncorrectSizeException {
        FilterValidator.throwWhenOutOfRange(n, 0, Integer.MAX_VALUE);
        return n;
    }
}
