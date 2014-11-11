/**
 * A generic filter interface.
 *
 * @author Shaun Howard
 */
public interface Filter<A extends Comparable<A>, B> {

    /**
     * Filters the input value of type A based on the filter type.
     *
     * @param value - the value to filter
     * @return the filtered value of type B
     */
    public B filter(A value);

}
