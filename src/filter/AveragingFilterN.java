package filter;

import exception.EmptyListException;
import exception.IncorrectSizeException;
import exception.NullValueException;

/**
 * <p>
 * An averaging implementation of the ScalarFilter interface. Implements all ScalarFilter operations
 * and does not permit null elements. This class also extends the FilterN abstract class with a type of Double. It
 * overrides the maintainN() operation in order to recalculate the stored average as well as removing elements
 * outside of the n range for efficiency purposes. In addition to implementing the ScalarFilter interface, this class
 * provides a method to obtain the stored average value as well.
 * </p>
 * <p>
 * All operations run in constant time.
 * </p>
 * <p>
 * Each AveragingFilterN has a double-precision floating point base average value that is maintained either from construction,
 * since the last reset, or when the maximum limit of n filter calls is reached. The values of filter calls are stored
 * in the FilterN class and can be reset with a call to the reset() method. After reset() is called, no previous data is retained.
 * Each instance will thus filter an average calculated with the last n filter input values, where n has a maximum of
 * the maximum size of a 32-bit integer. N is specified at construction time.
 * The calculated base average has a maximum value of up to the maximum size for a double-precision value.
 * </p>
 * <p>
 * On each call of filter or maintainN(), if the current iteration of filter call is larger than n, the values previous
 * to the last n filtered values stored will be truncated and not retained any further. Thus, the user only has access
 * to the last n filtered input values unless reset() is called.
 * </p>
 *
 * @author Shaun Howard
 */
public class AveragingFilterN extends FilterN<Double> implements ScalarFilter {

    // The average of previously entered values.
    double baseAverage;

    /**
     * Constructs an Averaging Filter that resets after N
     * values are filtered.
     *
     * @param n - the number of calls to reset the AveragingFilterN at
     */
    public AveragingFilterN(int n){
        super(n);
        baseAverage = 0;
    }

    /**
     * Calculates the average of the data entered thus far
     * @param value - the value to filter
     * @return the average of the last N values or since the last reset
     * @throws exception.NullValueException - thrown when the input value is null
     * @throws exception.EmptyListException - thrown when any used lists are empty
     * @throws exception.IncorrectSizeException - thrown when n is negative
     */
    /**
     * Recalculates the average of values filtered since instantiation, the last reset,
     * or the last n input values filtered depending on what condition is met during this call.
     * Adds the specified input value to a data structure which maintains the previous n input values.
     * Calls the maintainN() method to maintain the number of values used in average calculation.
     * Calls average() to calculate the average of the last n values input thus far.
     *
     * @param value - the Double value to filter
     * @return the average of the values filtered since instantiation or the last reset
     * @throws exception.NullValueException - if the input value is null
     * @throws exception.EmptyListException - if any lists under operation are empty but must not be
     * @throws exception.IncorrectSizeException - if n is not within the range [0, INTEGER_MAX_VALUE]
     */
    @Override
    public Double filter(Double value) throws NullValueException, EmptyListException, IncorrectSizeException {
        FilterValidator.throwExceptionWhenNull(value);
        maintainN();
        getValues().add(value);
        return average();
    }

    /**
     * Maintains the last n values input to the filter method in a data structure.
     * If more than n values are filtered, only the last n values are retained.
     * Recalculates the base average of the numbers seen thus far (N) after
     * truncating the values stored before the last n values.
     *
     * @throws exception.EmptyListException - if the list of stored input values is empty
     * @throws exception.IncorrectSizeException - if n is not within the range [0, INTEGER_MAX_VALUE]
     */
    @Override
    public void maintainN() throws EmptyListException, IncorrectSizeException {
        if (getValues().size() >= getN()) {
            FilterValidator.throwExceptionWhenEmpty(getValues());
            double firstValue = getValues().get(0);
            int count = getValues().size();
            getValues().remove(0);
            baseAverage = ((baseAverage * count) - firstValue) / --count;
        }
    }

    /**
     * Calculates the average of the previous n filtered input values.
     *
     * @return the average of the previous n filtered input values
     */
    private double average() {
        int count = getValues().size() - 1;
        double primValue = getValues().get(count);
        baseAverage = ((baseAverage * count) + primValue) / ++count;
        return baseAverage;
    }

    /**
     * Resets the filter by clearing any stored input values.
     */
    @Override
    public void reset() {
        getValues().clear();
    }
}
