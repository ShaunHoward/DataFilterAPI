package filter;

import exception.NullValueException;

/**
 * The resettable interface for the filter project.
 *
 * @author Shaun Howard
 */
public interface Resettable<A> {

    /**
     * Resets the filter with the given value.
     *
     * @param value - the value to reset the filter with
     * @throws exception.NullValueException - thrown when the input value is null
     */
    public void reset(A value) throws NullValueException;
}
