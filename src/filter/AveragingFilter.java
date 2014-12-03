package filter;

import exception.NullValueException;

/**
 * <p>
 * An averaging implementation of the ScalarFilter interface. Implements all ScalarFilter operations
 * and does not permit null elements. In addition to implementing the ScalarFilter interface, this class
 * provides methods to obtain the stored average value as well as the number of values filtered at the
 * time of information retrieval.
 * </p>
 * <p>
 * All operations run in constant time.
 * </p>
 * <p>
 * Each AveragingFilter has a double-precision floating point base average value that is maintained from construction
 * as well as an integer count of filtered values. Both the base average and the count of filtered values can be reset
 * to zero with the reset() method. After reset() is called, no previous data is retained.
 * Each instance will thus support up to either 2,147,483,647 filter calls (maximum 32-bit integer size) or a calculated
 * base average of up to the maximum size for a double-precision value.
 * </p>
 *
 * @author Shaun Howard
 */
public class AveragingFilter implements ScalarFilter {

    // The average of previously entered values.
    private double baseAverage;

    // The count of entered values.
    private int count;

    /**
     * Constructs an Averaging Filter.
     */
    public AveragingFilter(){
        baseAverage = 0;
        count = 0;
    }

    /**
     * Recalculates the average of values filtered since instantiation or
     * the last reset.
     * Increments the count of values filtered since instantiation or the last reset.
     *
     * @param value - the Double value to filter
     * @return the average of the values filtered since instantiation or the last reset
     * @throws exception.NullValueException - if the input value is null
     */
    @Override
    public Double filter(Double value) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(value);
        double primValue = value;
        baseAverage = ((baseAverage * count) + primValue) / ++count;
        return baseAverage;
    }

    /**
     * Resets the filter by setting base average and count to zero values.
     */
    @Override
    public void reset(){
        baseAverage = 0.0;
        count = 0;
    }

    /**
     * Gets the base average of this filter since instantiation
     * or its last reset.
     *
     * @return the base average of the filter at this point
     */
    public double getBaseAverage() {
        return baseAverage;
    }

    /**
     * Gets the count of values filtered since instantiation
     * or its last reset.
     *
     * @return the count of values filtered by this point
     */
    public int getCount() {
        return count;
    }
}
