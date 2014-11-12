import java.util.List;

/**
 * Filter Cascade is a cascade of different filters that filter a given
 * input value through the
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
     */
    @Override
    public B filter(A value){
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
     * Does nothing in this implementation.
     *
     * @param value - the value to reset the filter with
     */
    @Override
    public void reset(Comparable value) {
    }

}
