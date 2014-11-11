import java.util.Collections;
import java.util.List;

/**
 * A generic filter interface.
 *
 * @author Shaun Howard
 */
public interface Filter<A, B> {

    /**
     * Filters the input value of type A based on the filter type and
     * the last N values.
     * When reset is true, the filter is reset with the given input
     * value.
     * @param value - the value to filter
     * @param reset - whether value is a reset value
     * @return the filtered value of type B
     */
    public B filter(A value, boolean reset);

}
