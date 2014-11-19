package filter;

import exception.NullValueException;

/**
 * An Identity Filter returns the value input without
 * modification.
 *
 * @author Shaun Howard
 */
public class IdentityFilter<A extends Comparable<A>, B> implements Filter<A , B>{

    /**
     * Filters by returning the identity of the input.
     *
     * @param value - the value to filter
     * @return the identity of the value
     * @throws exception.NullValueException - thrown when the input value is null
     */
    @Override
    public B filter(A value) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(value);
        return (B)value;
    }

    /**
     * Reset is not implemented for this filter.
     *
     * @param value - the value to reset the filter with
     */
    @Override
    public void reset(A value) {

    }
}
