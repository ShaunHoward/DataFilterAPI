package filter;

import exception.NullValueException;

import java.util.List;

/**
 * A FilterCascade is a generic Filter of types A and B that is a cascade of different
 * filters of types A and B which filter a given input value through each filter
 * sequentially and return the filtered output from the cascade as type B. A
 * FilterCascade is constructed with a list of Filters of type A and B. Filters in the
 * filter cascade can only be reset individually but not as a whole.
 *
 * @author Shaun Howard
 */
public class FilterCascade<A extends Comparable<A>,B> implements Filter<A , B> {

    // The filters of the filter cascade.
    private List<Filter<A, B>> filters;

    /**
     * Constructs a filter cascade from generically typed filters.
     * @param filters - the filters to build the filter cascade with
     */
    public FilterCascade(List<Filter<A, B>> filters){
        this.filters = filters;
    }

    /**
     * Filters the input value through the filter cascade.
     *
     * @param value - the value to filter
     * @return the filtered value
     * @throws exception.NullValueException - thrown when the input value is null
     */
    @Override
    public B filter(A value) throws NullValueException {
        A output = value;
        for (Filter<A, B> filter : filters){
            output = (A)filter.filter(output);
        }
        return (B)output;
    }

    /**
     * Resets the selected filter with the given value.
     *
     * @param filter - the filter to reset at the given index
     * @param value - the value to reset the filter with
     */
    public void reset(int filter, A value){
        //check null
        //check 0 <= number < filter.size()

        filters.get(filter).reset(value);
    }

    /**
     * Reset that is not implemented.
     *
     * @param value - the value to reset the filter with
     */
    @Override
    public void reset(Comparable value) {
    }

}
