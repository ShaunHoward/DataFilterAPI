package filter;

import exception.NullValueException;

/**
 * An Averaging Filter is a scalar filter that returns
 * the average of the input data since the filter was
 * initialized or last reset.
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
     * Calculates the average of the data entered thus far.
     *
     * @param value - the value to filter
     * @return the average of the values seen thus far
     * @throws exception.NullValueException - thrown when the input value is null
     */
    @Override
    public Double filter(Double value) throws NullValueException {
        FilterValidator.throwExceptionWhenNull(value);
        double primValue = value;
        baseAverage = ((baseAverage * count) + primValue) / ++count;
        return baseAverage;
    }

    /**
     * Resets the filter by setting base average and count to 0.
     */
    @Override
    public void reset(){
        baseAverage = 0.0;
        count = 0;
    }

    /**
     * Gets the base average of the filter thus far, since beginning
     * or last reset.
     *
     * @return the base average of the filter thus far
     */
    public double getBaseAverage() {
        return baseAverage;
    }

    /**
     * Gets the count of values filtered thus far, since beginning or
     * last reset.
     *
     * @return the count of values filtered thus far
     */
    public int getCount() {
        return count;
    }
}
