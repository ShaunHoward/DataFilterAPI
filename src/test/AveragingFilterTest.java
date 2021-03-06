package test;

import exception.NullValueException;
import org.junit.Test;
import org.junit.Before;
import filter.AveragingFilter;

import static org.junit.Assert.assertEquals;

/**
 * A test class for the AveragingFilter class.
 * The numbers chosen to filter demonstrate the
 * class' support for signed and unsigned small, normal, and large-sized numbers but are
 * arbitrarily chosen and do not precisely represent any cases that have issues.
 *
 * @author Shaun Howard
 */
public class AveragingFilterTest {

    AveragingFilter avgFilter;

    @Before
    public void before() throws Exception {
        avgFilter = new AveragingFilter();
    }

    /**
     * Method: filter(Double value)
     * Type: Structured Basis
     */
    @Test
    public void testFilterStructure() throws Exception {
        assertEquals(300.0, avgFilter.filter(300.0), .01);
    }

    /**
     * Method: filter(Double value)
     * Type: Good data
     */
    @Test
    public void testFilterGoodData() throws Exception {
        assertEquals(300.0, avgFilter.filter(300.0), .01);
        assertEquals(1171321.1065, avgFilter.filter(2342342.213), .01);
        assertEquals(2.8032019402177875E11, avgFilter.filter(840958239423.123213123), .01);
        assertEquals(2.1024014551633405E11, avgFilter.filter(0.000001232123), .01);
        assertEquals(1.6819209177106723E11, avgFilter.filter(-123210.000001232123), .01);
        assertEquals(1.4016007647588922E11, avgFilter.filter(-0.00087868761232123), .01);
    }

    /**
     * Method: filter(Double value)
     * Type: Bad data
     */
    @Test(expected = NullValueException.class)
    public void testFilterBadData() throws Exception {
        avgFilter.filter(null);
    }

    /**
     * Method: reset()
     * Type: Structured basis / data flow
     */
    @Test
    public void testReset() throws Exception {
        assertEquals(300.0, avgFilter.filter(300.0), .01);
        assertEquals(1171321.1065, avgFilter.filter(2342342.213), .01);
        assertEquals(2.8032019402177875E11, avgFilter.filter(840958239423.123213123), .01);
        assertEquals(2.1024014551633405E11, avgFilter.filter(0.000001232123), .01);
        avgFilter.reset();
        assertEquals(0.0, avgFilter.getBaseAverage(), 0.01);
        assertEquals(0, avgFilter.getCount());
    }
} 
