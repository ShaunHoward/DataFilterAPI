import java.util.ArrayList;
import java.util.List;

/**
 * An Averaging Filter N is a scalar filter that returns
 * the average of the input data since the last N values
 * or the last reset.
 *
 * @author Shaun Howard
 */
public class AveragingFilterN extends FilterN<Double> implements ScalarFilter {

    /**
     * Constructs an Averaging Filter that resets after N
     * values are filtered.
     *
     * @param n - the number of calls to reset
     *          the filter at
     */
    public AveragingFilterN(int n){
        //check null
        super(n);
    }

    /**
     * Calculates the average of the data entered thus far
     * @param value - the value to filter
     * @return
     */
    public double filter(double value){
        //check null

        maintainN();
        getValues().add(value);
        return average();
    }

    /**
     * Calculates the average of the stored values.
     *
     * @return the average of the stored values
     */
    private double average() {
        double sum = 0;
        for (double value : getValues()){
            sum += value;
        }
        return sum / getValues().size();
    }

    /**
     * Resets the filter with the given value.
     *
     * @param value - the value to reset the filter with
     */
    public void reset(double value){
        //check null

        getValues().clear();
        getValues().add(value);
    }
}
