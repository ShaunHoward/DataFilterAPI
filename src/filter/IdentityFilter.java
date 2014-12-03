package filter;

import exception.NullValueException;

/**
 * <p>
 * An IdentityFilter is a generic implementation of the Filter interface designed to filter the specified input value
 * into the type of the output while retaining its identity data. Implements all Filter operations. Only has an empty
 * constructor due to simplicity of filter.
 * </p>
 * <p>
 * IdentityFilter overrides the filter method of Filter. In this implementation, specific values are accepted.
 * The specified input value must not be null or a checked NullValueException will be thrown.
 * </p>
 * <p>
 * This class only supports types A and B where B is a subclass of A. If type B is not a subclass of type A,
 * an unchecked ClassCastException will be thrown and caught within the filter method, printing a message
 * to the standard error stream.
 * Thus, if incorrect type parameters are used to instantiate an IdentityFilter, filter will always return a null value
 * and print an error message.
 * </p>
 *
 * @param <A> - the comparable type of input element to filter
 * @param <B> - the type of output element produced by the filter
 *
 * @author Shaun Howard
 */
public class IdentityFilter<A extends Comparable<A>, B> implements Filter<A , B>{

    /**
     * Filters by returning the identity of the input as type B.
     *
     * @param value - the value to filter
     * @return the identity of the filtered value as type B
     * @throws exception.NullValueException - if the input value is null
     */
    @Override
    public B filter(A value) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(value);
        try {
            return (B)value;
        } catch (ClassCastException cce){
            System.err.println("Cannot cast properly with typing of IdentityFilter.");
            return null;
        }
    }
}
