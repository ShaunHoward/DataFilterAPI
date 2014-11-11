/**
 * Created by shaun on 11/10/14.
 */
public class ScalarFilter implements Filter<Double, Double> {

    public Double filter(Double value, boolean reset){
        return Double.MAX_VALUE;
    }
}
