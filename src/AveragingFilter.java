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
     * Calculates the average of the data entered thus far
     *
     * @param value - the value to filter
     * @return the average of the values seen thus far
     */
    public Double filter(Double value){
        //check null
        double primValue = value;
        baseAverage = ((baseAverage * count) + primValue) / ++count;
        return baseAverage;
    }

    /**
     * Resets the filter with by setting sum and count to 0.
     */
    public void reset(){
        baseAverage = 0.0;
        count = 0;
    }

    public void reset(Double value){
        //not implemented
    }
}
