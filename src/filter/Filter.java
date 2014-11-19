package filter;

import exception.EmptyListException;
import exception.IncorrectSizeException;
import exception.NullValueException;

/**
 * A generic filter interface.
 *
 * The filter can be reset with a given value of type A.
 *
 * @author Shaun Howard
 */
public interface Filter<A extends Comparable<A>, B> {

    /**
     * Filters the input value of type A based on the filter type.
     *
     * @param value - the value to filter
     * @return the filtered value of type B
     * @throws exception.NullValueException - thrown when the input value is null
     * @throws exception.EmptyListException - thrown when any lists are null under operation
     * @throws exception.IncorrectSizeException - thrown when any sizes are incorrect
     */
    public B filter(A value) throws NullValueException, EmptyListException, IncorrectSizeException;

}
