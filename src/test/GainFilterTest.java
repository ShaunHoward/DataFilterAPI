package test;

import filter.GainFilter;
import org.junit.Test; 
import org.junit.Before; 

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/** 
* A test class for the GainFilter class.
* The numbers chosen to filter demonstrate the
* class' support for signed and unsigned small, normal, and large-sized numbers but are
* arbitrarily chosen and do not precisely represent any cases that have issues.
* 
* @author Shaun Howard
*/ 
public class GainFilterTest {
    GainFilter gainFilter;
    ArrayList<Double> gainList;
    static final double GAIN = 5.5;
    Double[] gainArr = {4.5, 800.323, 2342352645243.2343464534534534, 0.0000000000001};

    @Before
    public void before() throws Exception {
        gainList = new ArrayList<>();
        for (Double value : gainArr) {
            gainList.add(value);
        }
        gainFilter = new GainFilter(GAIN);
    }

    /**
     * Method: filter(value)
     * Structured Basis, Good data
     */
    @Test
    public void testFilter() throws Exception {
        assertEquals(249.14999999999998, gainFilter.filter(45.3), 0.01);
        assertEquals(1906.652, gainFilter.filter(346.664), 0.01);
        assertEquals(1.288287E-7, gainFilter.filter(.0000000234234), 0.01);
        assertEquals(6.778317382938486E15, gainFilter.filter(1232421342352452.), 0.01);
        assertEquals(249.14999999999998, gainFilter.filter(45.3), 0.01);
        assertEquals(-2.661061123789488E9, gainFilter.filter(-483829295.23445234), 0.01);
    }
} 
