/**
 * An Averaging Filter is a scalar filter that returns
 * the average of the input data since the filter was
 * initialized or last reset.
 *
 * @author Shaun Howard
 */
public class AveragingFilter implements ScalarFilter {

    // The sum of the previously entered values.
    private double sum;

    // The count of entered values.
    private int count;

    // Whether the filter has hit it's limit of input tracking.
    private boolean hitLimit;

    /**
     * Constructs an Averaging Filter.
     */
    public AveragingFilter(){
        sum = 0;
        count = 0;
        hitLimit = false;
    }

    /**
     * Calculates the average of the data entered thus far
     * @param value - the value to filter
     * @return
     */
    public double filter(double value){
        sum += value;
        count++;
        return sum / count;
    }

    /**
     * Resets the filter with the given value.
     *
     * @param value - the value to reset the filter with
     */
    public void reset(double value){
        sum = value;
        count = 0;
    }
}
