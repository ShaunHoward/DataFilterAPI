package filter;

import exception.EmptyListException;
import exception.IncorrectSizeException;
import exception.NullValueException;

/**
 * <p>
 * A MaxFilter is a generic implementation of the Filter interface designed to filter a given input value based on
 * the maximum value seen since either instantiation, when the maximum limit of n filter calls is reached or the last
 * reset. Implements all Filter operations. Since it considers only the n last values filtered thus far it is a generic
 * FilterN of type A. This class also implements the Resettable interface. Implements all Resettable operations.
 * </p>
 * <p>
 * Overrides the filter method of Filter by filtering based on the maximum value of type A seen since either class instantiation,
 * the values given in the last n filter calls or since the last reset. The filter method adds the input value to the
 * collection of stored filter values, then calls the max method. This method finds the maximum value of the last n
 * input filter values with calls compareTo to compare the stored maximum filtered values in order to determine which
 * is greatest. In this filter implementation, only specific values are accepted. The specified input value must not be null or a
 * checked NullValueException will be thrown. After n filter calls, any values input before the last n filter calls
 * will be truncated and thus that data will not be retained.
 * </p>
 * <p>
 * Overrides the reset method of Resettable. The collection of maximum stored values will be emptied and the specified
 * value on the method call will be added to the collection. When the input value is null, a checked NullValueException
 * is thrown. Thus, no previous data is retained after reset is called.
 * </p>
 * <p>
 * The filter and max operations take linear time due to the comparison of all n stored filter input values.
 * All other operations take constant time.
 * </p>
 * <p>
 * This class only supports types A and B where B is a subclass of A. If type B is not a subclass of type A,
 * an unchecked ClassCastException will be thrown and caught within the filter method, printing a message
 * to the standard error stream.
 * Thus, if incorrect type parameters are used to instantiate a MaxFilter, filter will always return a null value
 * and print an error message.
 * </p>
 *
 * @param <A> - the comparable type of input element to filter
 * @param <B> - the type of output element produced by the filter
 *
 * @author Shaun Howard
 */
public class MaxFilterN<A extends Comparable<A>,B> extends FilterN<A> implements Filter<A,B>, Resettable<A> {

    /**
     * Constructs a Max Filter that only filters the last N
     * filter input values.
     *
     * @param n - the number of input values to filter
     */
    public MaxFilterN(int n){
        super(n);
    }

    /**
     * Filters the input value by returning the maximum
     * value input of since instantiation, the last N inputs or since the
     * last reset.
     *
     * @param value - the value to filter
     * @return the maximum value yet seen by the filter
     * @throws exception.NullValueException - if the input value is null
     * @throws exception.EmptyListException - if the list of values is null
     * @throws exception.IncorrectSizeException - if n is not in the range [0, INTEGER_MAX_VALUE]
     */
    @Override
    public B filter(A value) throws NullValueException, EmptyListException, IncorrectSizeException {
        FilterValidator.throwExceptionWhenNull(value);
        maintainN();
        getValues().add(value);
        return max();
    }

    /**
     * Resets the filter with the given value.
     *
     * @param value - the value to reset the filter with
     * @throws exception.NullValueException - if the input value is null
     */
    public void reset(A value) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(value);
        getValues().clear();
        getValues().add(value);
    }

    /**
     * Returns the maximum element in the collection of filtered values.
     *
     * @return the max element in the collection of filtered values
     */
    private B max(){
        A max = null;
        boolean first = true;
        for (A value : getValues()){
            if (first){
                first = false;
                max = value;
            }
            if (value.compareTo(max) > 0){
                max = value;
            }
        }
        try {
            return (B)max;
        } catch (ClassCastException cce){
            System.err.println("Cannot cast properly with typing of MaxFilterN.");
            return null;
        }
    }
}
