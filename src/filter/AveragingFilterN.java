package filter;

import exception.EmptyListException;
import exception.IncorrectSizeException;
import exception.NullValueException;

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
     * @throws exception.NullValueException - thrown when the input value is null
     * @throws exception.IncorrectSizeException - thrown when n is negative
     */
    @Override
    public Double filter(Double value) throws NullValueException, EmptyListException, IncorrectSizeException {
        FilterValidator.throwExceptionWhenNull(value);
        maintainN();
        getValues().add(value);
        return average();
    }

    /**
     * Removes the front node of the list if
     * the size of the list is greater than or equal to
     * n. Then recalculates the base average of the numbers
     * seen thus far (N-1).
     * @throws exception.EmptyListException - thrown when the list of values is empty
     * @throws exception.IncorrectSizeException - thrown when n is negative
     */
    @Override
    public void maintainN() throws EmptyListException, IncorrectSizeException {
        if (getValues().size() >= getN()) {
            FilterValidator.throwExceptionWhenEmpty(getValues());
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
     */
    @Override
    public void reset() {
        getValues().clear();
    }
}
