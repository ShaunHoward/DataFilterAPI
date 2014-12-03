package filter;

import exception.EmptyListException;
import exception.IncorrectSizeException;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class provides a skeletal implementation of a generic FilterN which should be used
 * in tandem with the Filter interface. This class is designed to reduce the effort needed
 * when limiting the amount of values filtered by a Filter implementation.
 * </p>
 * <p>
 * To change the functionality of the filter n, a user must override the maintainN() method. By
 * doing so, the user will change how the n value is calculated in order to limit the number of
 * values filtered. Currently, when a filter has one too many values filtered past count n, the
 * maintainN() method with truncate and forget the first value entered to the filter before the
 * last truncation.
 * A user could also create a new data structure and override the getValues() method in order to
 * change the way values are retrieved from the filter n instance.
 * </p>
 * <p>
 * Both a count of values filtered thus far and a data structure of filtered values are maintained
 * in order to track the previous n values since the last maintainN() method call.
 * </p>
 * <p>
 * A FilterN has limitations on the usage of methods maintainN() and getN(). The earlier throws either a
 * checked EmptyListException when the data structure maintaining the filtered values is empty or a checked
 * IncorrectSizeException, due to a call to getN().
 * The latter throws a checked IncorrectSizeException when n is not within the range [0, INTEGER_MAX_VALUE].
 * </p>
 *
 * @param <A> - the comparable type of input element to filter
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
     * Maintains a count of n elements within the filter n instance.
     * This method can be overridden to change the functionality of how
     * a count of values past n is handled.
     *
     * @throws exception.EmptyListException - if data structure maintaining values is empty
     * @throws exception.IncorrectSizeException - if n lies outside the range [0, INTEGER_MAX_VALUE]
     */
    public void maintainN() throws EmptyListException, IncorrectSizeException {
        if (values.size() >= getN()) {
            FilterValidator.throwExceptionWhenEmpty(values);
            values.remove(0);
        }
    }

    /**
     * Gets a list representation of values filtered thus far.
     *
     * @return a list of values filtered thus far
     */
    public List<A> getValues() {
        return values;
    }

    /**
     * Gets the maximum count of values to filter, n.
     *
     * @return the maximum count of values to filter
     * @throws exception.IncorrectSizeException - if n lies outside the range [0, INTEGER_MAX_VALUE]
     */
    public int getN() throws IncorrectSizeException {
        FilterValidator.throwWhenOutOfRange(n, 0, Integer.MAX_VALUE);
        return n;
    }
}
