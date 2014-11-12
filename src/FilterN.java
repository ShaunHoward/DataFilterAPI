import java.util.ArrayList;
import java.util.List;

/**
 * A Filter N abstract class that only considers the last N values input
 * to the filter.
 *
 * @author Shaun Howard
 */
public abstract class FilterN<A extends Comparable<A>> {

    // The count to reset the filter at.
    private int n = 0;

    // An array of stored input values.
    List<A> values;

    /**
     * Constructs a new Filter N that tracks n
     * previous inputs for filtering.
     *
     * @param n - the number of previous inputs tracked
     */
    public FilterN(int n){
        //check null

        this.n = n;
        values = new ArrayList<>();
    }

    /**
     * Removes the front node of the list if
     * the size of the list is greater than or equal to
     * n.
     */
    void maintainN(){
        if (values.size() >= n) {
            values.remove(0);
        }
    }

    /**
     * Resets the filter with the given value.
     *
     * @param value - the value to reset the filter with
     */
    public void reset(A value){
        //check null

        values.clear();
        values.add(value);
    }
}
