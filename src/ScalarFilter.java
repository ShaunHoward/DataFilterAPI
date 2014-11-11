/**
 * Created by shaun on 11/10/14.
 */
public class ScalarFilter {

    private double multiplier;

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
