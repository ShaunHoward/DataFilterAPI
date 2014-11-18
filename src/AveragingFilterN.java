/**
 * An Averaging Filter N is a scalar filter that returns
 * the average of the input data since the last N values
 * or the last reset.
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
     * @param n - the number of calls to reset
     *          the filter at
     */
    public AveragingFilterN(int n){
        super(n);
        baseAverage = 0;
    }

    /**
     * Calculates the average of the data entered thus far
     * @param value - the value to filter
     * @return the average of the last N values or since the last reset
     */
    @Override
    public Double filter(Double value){
        //check that value is not null.

        maintainN();
        getValues().add(value);
        return average();
    }

    /**
     * Removes the front node of the list if
     * the size of the list is greater than or equal to
     * n. Then recalculates the base average of the numbers
     * seen thus far (N-1).
     */
    @Override
    public void maintainN(){
        if (getValues().size() >= getN()) {
            double firstValue = getValues().get(0);
            int count = getValues().size();
            getValues().remove(0);
            baseAverage = ((baseAverage * count) - firstValue) / --count;
        }
    }

    /**
     * Calculates the average of the stored values.
     *
     * @return the average of the stored values
     */
    private double average() {
        int count = getValues().size() - 1;
        double primValue = getValues().get(count);
        baseAverage = ((baseAverage * count) + primValue) / ++count;
        return baseAverage;
    }

    /**
     * Resets the filter by clearing the values list.
     *
     * @param value - the value to reset the filter with
     */
    public void reset(double value){
        reset();
    }

    /**
     * Resets the filter by clearing the values list.
     */
    @Override
    public void reset() {
        getValues().clear();
    }
}
