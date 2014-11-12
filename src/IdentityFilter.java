/**
 * An Identity Filter returns the value input without
 * modification.
 *
 * @author Shaun Howard
 */
public class IdentityFilter<A> {

    /**
     * Filters by return the identity of the input.
     *
     * @param value - the value to filter
     * @return the identity of the value
     */
    public A filter(A value){
        //check null

        return value;
    }
}
