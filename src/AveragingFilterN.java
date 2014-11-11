import java.util.ArrayList;
import java.util.List;

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

    // The count to reset the filter at.
    private int n = 0;

    // Whether the filter has hit it's limit of input tracking.
    private boolean hitLimit = false;

    // An array of previously input values.
    private List<Double> prevValues;

    /**
     * Constructs an Averaging Filter that resets after N
     * values are filtered.
     *
     * @param n - the number of calls to reset
     *          the filter at
     */
    public AveragingFilterN(int n){
        this.n = n;
        prevValues = new ArrayList<>();
    }

    /**
     * Calculates the average of the data entered thus far
     * @param value - the value to filter
     * @return
     */
    public double filter(double value){
        if (count >= n && !hitLimit) {
            hitLimit = true;
            removeFront();
        } else if (count >= n){
            removeFront();
        }
        prevValues.add(value);
        return average();
    }

    private double average() {
    }

    /**
     * Removes the front object from the stored previous values
     * list.
     */
    public void removeFront(){
        prevValues.remove(0);
    }

    /**
     * Resets the filter with the given value.
     *
     * @param value - the value to reset the filter with
     */
    public void reset(double value){
        sum = value;
        count = 0;
        hitLimit = false;
        prevValues = new double[n];
    }


}
