/**
 * An Averaging Filter is a scalar filter that returns
 * the average of the input data since the filter was
 * initialized or last reset.
 *
 * @author Shaun Howard
 */
public class AveragingFilter extends AveragingFilterN {

    public AveragingFilter(){
        super(Integer.MAX_VALUE);
    }

}
