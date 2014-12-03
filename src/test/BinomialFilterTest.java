package test;

import filter.BinomialFilter;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * BinomialFilter Tester.
 *
 * @author Shaun Howard
 * @version 1.0
 * @since <pre>Nov 18, 2014</pre>
 */
public class BinomialFilterTest {

    BinomialFilter bf;
    ArrayList<Double> bfList;
    Double[] bfArr = {4.5, 800.323, 2342352645243.2343464534534534, 0.0000000000001};

    @Before
    public void before() throws Exception {
        bfList = new ArrayList<>();
        for (Double value : bfArr) {
            bfList.add(value);
        }
        bf = new BinomialFilter(bfList.size(), bfList);
    }

    /**
     * Method: filter(value)
     * Structured Basis, Good data
     */
    @Test
    public void testFilter() throws Exception {
        assertEquals(45.3, bf.filter(45.3), 0.01);
        assertEquals(527.864, bf.filter(346.664), 0.01);
        assertEquals(1658.4560000234233, bf.filter(.0000000234234), 0.01);
        assertEquals(1.2324213423547132E15, bf.filter(1232421342352452.), 0.01);
        assertEquals(4.92968536941124E15, bf.filter(45.3), 0.01);
        assertEquals(7.394527570285598E15, bf.filter(-483829295.23445234), 0.01);
    }

    /**
     * Method: setBinomials()
     */
    @Test
    public void testSetBinomials() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = BinomialFilter.getClass().getMethod("setBinomials"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: binomialC(int n, int i)
     */
    @Test
    public void testBinomialC() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = BinomialFilter.getClass().getMethod("binomialC", int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
