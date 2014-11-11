/**
 * Scalar filter class.
 *
 * @author Shaun Howard
 */
public class ScalarFilter {

    //The value to multiply input with.
    private double multiplier;

    /**
     * Constructs a scalar filter from the given multiplier.
     *
     * @param multiplier - the filter multiplier
     */
    public ScalarFilter(double multiplier){
        this.multiplier = multiplier;
    }

    /**
     * Filters the input value by multiplication with
     * the filter multiplier.
     * Returns the filtered value.
     *
     * @param value - the value to filter
     * @return the filtered value
     */
    public Double filter(Double value){
        return value * multiplier;
    }
}
