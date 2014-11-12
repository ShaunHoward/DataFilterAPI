/**
 * Max Filter N is a max filter that returns the maximum of the
 * last N values seen or the maximum value seen since the last
 * reset if less than N values were encountered.
 *
 * @author Shaun Howard
 */
public class MaxFilterN<A extends Comparable<A>,B> extends FilterN<A> implements Filter<A,B> {

    /**
     * Constructs a Max Filter that resets after N
     * values are filtered.
     *
     * @param n - the number of calls to reset
     *          the filter at
     */
    public MaxFilterN(int n){
        super(n);
    }

    /**
     * Filters the input value by returning the maximum
     * value input of the last N inputs or since the
     * last reset.
     * @param value - the value to filter
     * @return the maximum value yet seen by the filter
     */
    public B filter(A value){
        //check null
        maintainN();
        getValues().add(value);
        return max();
    }

    /**
     * Returns the maximum element in the list of values.
     *
     * @return the max element in the list of values
     */
    private B max(){
        A max = null;
        boolean first = true;
        for (A value : getValues()){
            if (first){
                first = false;
                max = value;
            }
            if (value.compareTo(max) > 0){
                max = value;
            }
        }
        return (B)max;
    }

}
