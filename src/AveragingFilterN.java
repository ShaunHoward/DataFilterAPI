/**
 * An Averaging Filter N is a scalar filter that returns
 * the average of the input data since the last N values
 * or the last reset.
 *
 * @author Shaun Howard
 */
public class AveragingFilterN implements ScalarFilter {

    // The sum of the previously entered values.
    private double sum = 0;

    // The count of entered values.
    private int count = 0;

    private int n = 0;

    /**
     * Constructs an Averaging Filter that resets after N
     * values are filtered.
     *
     * @param n - the number of calls to reset
     *          the filter at
     */
    public AveragingFilterN(int n){
        this.n = n;
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


}
