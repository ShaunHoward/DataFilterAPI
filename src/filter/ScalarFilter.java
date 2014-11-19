package filter;

import exception.EmptyListException;
import exception.IncorrectSizeException;
import exception.NullValueException;

/**
 * A scalar filter interface.
 *
 * A scalar filter is a filter that maintains a previously calculated double value
 * and appends an input double value to that value in order to calculate the output
 * desired for the implementing filter. The filter can be reset with a given value
 * of type double.
 *
 * @author Shaun Howard
 */
public interface ScalarFilter extends Filter<Double, Double> {

    /**
     * Filters the input value based on the previous input.
     * Returns the filtered value.
     *
     * @param value - the value to filter
     * @return the filtered value
     * @throws exception.NullValueException - thrown when the input value is null
     * @throws exception.EmptyListException - thrown when any lists used to filter are empty
     * @throws exception.IncorrectSizeException - thrown when any sizes used to filter are mismatched
     */
    public Double filter(Double value) throws NullValueException, EmptyListException, IncorrectSizeException;

    /**
     * Resets the filter with 0.0.
     */
    public void reset();
}
