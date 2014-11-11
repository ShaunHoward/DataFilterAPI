/**
 * Created by shaun on 11/10/14.
 */
public class IdentityFilter<A> {

    /**
     * Filters by return the identity of the input.
     *
     * @param value - the value to filter
     * @return the identity of the value
     */
    public A filter(A value){
        return value;
    }
}
