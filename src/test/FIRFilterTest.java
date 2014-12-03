package test;

import filter.FIRFilter;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/** 
* A test class for the FIRFilter class.
* The numbers chosen to filter demonstrate the
* class' support for signed and unsigned small, normal, and large-sized numbers but are
* arbitrarily chosen and do not precisely represent any cases that have issues.
* 
* @author Shaun Howard
*/ 
public class FIRFilterTest {

    FIRFilter firFilter;
    ArrayList<Double> firList;
    Double[] firArr = {4.5, 800.323, 2342352645243.2343464534534534, 0.0000000000001};

    @Before
    public void before() throws Exception {
        firList = new ArrayList<>();
        for (Double value : firArr) {
            firList.add(value);
        }
        firFilter = new FIRFilter(firList.size(), firList);
    }

    /**
     * Method: filter(value)
     * Structured Basis, Good data
     */
    @Test
    public void testFilter() throws Exception {
        assertEquals(203.85, firFilter.filter(45.3), 0.01);
        assertEquals(37814.6199, firFilter.filter(346.664), 0.01);
        assertEquals(1.0610857510696169E14, firFilter.filter(.0000000234234), 0.01);
        assertEquals(6.357905377996635E15, firFilter.filter(1232421342352452.), 0.01);
        assertEquals(9.8633514597559654E17, firFilter.filter(45.3), 0.01);
        assertEquals(2.886765391313484E27, firFilter.filter(-483829295.23445234), 0.01);
    }
} 
