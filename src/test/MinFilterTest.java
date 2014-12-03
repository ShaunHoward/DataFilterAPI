package test;

import exception.NullValueException;
import filter.MinFilter;
import org.junit.Test; 
import org.junit.Before;

import java.util.Vector;

import static org.junit.Assert.assertEquals;

/** 
* A test class for the MinFilter class.
* The numbers chosen to filter demonstrate the
* class' support for signed and unsigned small, normal, and large-sized numbers but are
* arbitrarily chosen and do not precisely represent any cases that have issues.
* 
* @author Shaun Howard
*/ 
public class MinFilterTest {
    MinFilter<Double, Double> minFilter;
    MinFilter<Integer, Vector> badMinFilter;

    @Before
    public void before() throws Exception {
        minFilter = new MinFilter<>();
        badMinFilter = new MinFilter<Integer, Vector>();
    }

    /**
     * Method: filter(Double value)
     * Structured Basis
     */
    @Test
    public void testFilterStructure() throws Exception {
        assertEquals(300.0, minFilter.filter(300.0), .01);
    }

    /**
     * Method: filter(Double value)
     * Structured Basis, Good Data
     */
    @Test
    public void testFilterGoodData() throws Exception {
        assertEquals(300.0, minFilter.filter(300.0), .01);
        assertEquals(300.0, minFilter.filter(2342342.213), .01);
        assertEquals(300.0, minFilter.filter(840958239423.123213123), .01);
        assertEquals(0.000001232123, minFilter.filter(0.000001232123), .01);
        assertEquals(-123210.000001232123, minFilter.filter(-123210.000001232123), .01);
        assertEquals(-123210.000001232123, minFilter.filter(-0.00087868761232123), .01);
    }

    /**
     * Method: filter(Double value)
     * Structured Basis, bad typing/data
     */
    @Test
    public void testFilterBadTypes() throws Exception {
        assertEquals(23423, badMinFilter.filter(23423));
    }

    /**
     * Method: filter(Double value)
     * Bad data
     */
    @Test(expected = NullValueException.class)
    public void testFilterBadData() throws Exception {
        minFilter.filter(null);
    }

    /**
     * Method: reset()
     * Structured basis / data flow
     */
    @Test
    public void testReset() throws Exception {
        assertEquals(300.0, minFilter.filter(300.0), .01);
        assertEquals(300.0, minFilter.filter(2342342.213), .01);
        assertEquals(-840958239423.123213123, minFilter.filter(-840958239423.123213123), .01);
        assertEquals(-840958239423.123213123, minFilter.filter(0.000001232123), .01);
        minFilter.reset(0.0);
        assertEquals(0.0, minFilter.getMin(), 0.01);
    }

    /**
     * Method: reset()
     * Structured basis / data flow
     */
    @Test(expected = NullValueException.class)
    public void testResetBadData() throws Exception {
        assertEquals(300.0, minFilter.filter(300.0), .01);
        assertEquals(300.0, minFilter.filter(2342342.213), .01);
        assertEquals(-840958239423.123213123, minFilter.filter(-840958239423.123213123), .01);
        assertEquals(-840958239423.123213123, minFilter.filter(0.000001232123), .01);
        minFilter.reset(null);
    }

} 
