package filter;

import exception.EmptyListException;
import exception.IncorrectSizeException;
import exception.NullValueException;

import java.util.List;

/**
 * <p>
 * A FilterCascade is a generic implementation of the Filter interface designed to filters a given input value through
 * a cascade of Filters sequentially. Implements all Filter operations.
 * </p>
 * <p>
 * FilterCascade is constructed with a list of Filters of type A, which must implement comparable, and type B. Filters in the
 * filter cascade can only be reset individually but not as a whole. The filter method runs the specified input value
 * through the filters in the order they are indexed (from 0 to length) within the filter list. If the list of filters
 * specified during construction is empty, the input value will be returned as type B.
 * </p>
 * <p>
 * This class only supports types A and B where B is a subclass of A. If type B is not a subclass of type A,
 * an unchecked ClassCastException will be thrown and caught within the filter method, printing a message
 * to the standard error stream.
 * Thus, if incorrect type parameters are used to instantiate a FilterCascade, the filter method will not work properly
 * and will only return null values.
 * </p>
 *
 * @param <A> - the comparable type of input element to filter
 * @param <B> - the type of output element produced by the filter
 *
 * @author Shaun Howard
 */
public class FilterCascade<A extends Comparable<A>,B> implements Filter<A , B> {

    // The filters of the filter cascade.
    private List<Filter<A, B>> filters;

    /**
     * Constructs a filter cascade from generically typed filters.
     *
     * @param filters - filters used to build the filter cascade
     */
    public FilterCascade(List<Filter<A, B>> filters){
        this.filters = filters;
    }

    /**
     * Filters the specified input through the filter cascade.
     *
     * @param value - the value to filter
     * @return the filtered value
     * @throws exception.NullValueException - if the input value is null
     * @throws exception.EmptyListException - if any lists under operation in filters are empty
     * @throws exception.IncorrectSizeException - if any mismatched sizes are found during operation of
     * filters
     */
    @Override
    public B filter(A value) throws NullValueException, EmptyListException, IncorrectSizeException {
        A output = value;
        try {
            for (Filter<A, B> filter : filters){
                output = (A)filter.filter(output);
            }
            return (B)output;
        } catch (ClassCastException cce){
            System.err.println("Cannot cast properly with typing of FilterCascade.");
            return null;
        }
    }
}
