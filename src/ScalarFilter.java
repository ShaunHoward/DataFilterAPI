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
public interface ScalarFilter {

    /**
     * Filters the input value based on the previous input.
     * Returns the filtered value.
     *
     * @param value - the value to filter
     * @return the filtered value
     */
    public double filter(double value);

    /**
     * Resets the filter with the input value.
     *
     * @param value - the value to reset the filter with
     */
    public void reset(double value);
}
