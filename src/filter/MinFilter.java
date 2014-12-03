package filter;

import exception.NullValueException;

/**
 * <p>
 * A MinFilter is a generic implementation of the Filter interface designed to filter a given input value based on
 * the minimum value seen since either instantiation or the last reset. Implements all Filter operations.This class
 * also implements the Resettable interface. Implements all Resettable operations. The user has the ability to obtain
 * the minimum filtered value since either instantiation or the last reset call. The class thus stores the last minimum
 * value filtered.
 * </p>
 * <p>
 * Overrides the filter method by filtering based on the minimum value of type A seen since either class instantiation
 * or the last reset. The filter method calls compareTo to compare the stored minimum filtered value with the specified
 * input value in order to determine which is greater. In this implementation, only specific values are accepted.
 * The specified input value must not be null or a checked NullValueException will be thrown.
 * </p>
 * <p>
 * Overrides the reset method of Resettable. The minimum stored value will be reset to the specified value on the method
 * call. When input value is null, a checked NullValueException is thrown.
 * </p>
 * <p>
 * All operations take constant time.
 * </p>
 * <p>
 * This class only supports types A and B where B is a subclass of A. If type B is not a subclass of type A,
 * an unchecked ClassCastException will be thrown and caught within the filter method, printing a message
 * to the standard error stream.
 * Thus, if incorrect type parameters are used to instantiate a MinFilter, filter will always return a null value
 * and print an error message.
 * </p>
 *
 * @param <A> - the comparable type of input element to filter
 * @param <B> - the type of output element produced by the filter
 *
 * @author Shaun Howard
 */
public class MinFilter<A extends Comparable<A>,B> implements Filter<A , B>, Resettable<A> {

    // The minimum value found thus far.
    private A min;

    /**
     * Filters the minimum input value since the filter was initialized or
     * was last reset.
     *
     * @param value - the value to filter
     * @return the minimum seen by the filter thus far as type B
     * @throws exception.NullValueException - thrown when the input value is null
     */
    @Override
    public B filter(A value) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(value);
        if (min == null || value.compareTo(min) < 0) {
            min = value;
        }
        try {
            return (B)min;
        } catch (ClassCastException cce){
            System.err.println("Cannot cast properly with typing of MinFilter.");
            return null;
        }
    }

    /**
     * Resets the filter with the specified value.
     *
     * @param value - the value to reset the filter with
     * @throws exception.NullValueException - thrown when the input value is null
     */
    @Override
    public void reset(A value) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(value);
        this.min = value;
    }

    /**
     * Gets the minimum value seen thus far.
     *
     * @return the min value seen thus far
     */
    public A getMin(){
        return this.min;
    }
}