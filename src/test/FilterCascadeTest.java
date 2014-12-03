package test;

import filter.*;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * FilterCascade Tester.
 *
 * @author Shaun Howard
 * @version 1.0
 * @since <pre>Nov 18, 2014</pre>
 */
public class FilterCascadeTest {

    AveragingFilter avgFilter;
    FIRFilter firFilter;
    MaxFilter maxFilter;
    FilterCascade<Double, Double> fCascade;
    FilterCascade<Integer, Double> badFCascade;
    ArrayList<Double> firValues;
    ArrayList<Filter> fList;

    @Before
    public void before() throws Exception {
        fList = new ArrayList<>();
        avgFilter = new AveragingFilter();
        fList.add(avgFilter);
        firValues = new ArrayList<Double>();
        firValues.add(23423523.23423);
        firValues.add(-.0022342342);
        firFilter = new FIRFilter(2, firValues);
        fList.add(firFilter);
        maxFilter = new MaxFilter();
        fList.add(maxFilter);
        fCascade = new FilterCascade(fList);
        badFCascade = new FilterCascade(fList);
    }

    /**
     * Method: filter(A value)
     * Structured Basis
     */
    @Test
    public void testFilter() throws Exception {
        assertEquals(5.493416389280824E13, fCascade.filter(2345256.23423423), 0);
    }

    /**
     * Method: filter(A value)
     * Structured Basis
     */
    @Test
    public void testBadFilter() throws Exception {
        assertEquals(null, badFCascade.filter(23423425));
    }
} 
