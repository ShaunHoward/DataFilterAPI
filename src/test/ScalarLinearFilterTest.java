package test;

import filter.ScalarLinearFilter;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * ScalarLinearFilter Tester.
 *
 * @author Shaun Howard
 * @version 1.0
 * @since <pre>Nov 18, 2014</pre>
 */
public class ScalarLinearFilterTest {

    ScalarLinearFilter slFilter;
    ArrayList<Double> a, b;

    @Before
    public void before() throws Exception {
        a = new ArrayList<Double>();
        b = new ArrayList<Double>();
        a.add(5.5);
        a.add(6.6);
        a.add(1341242342.2342342);
        a.add(.343453);
        b.add(5.5);
        b.add(6.6);
        b.add(1341242342.2342342);
        b.add(-.343453);
        slFilter = new ScalarLinearFilter(4, 4, a, b);
    }

    /**
     * Method: filter(Double in)
     */
    @Test
    public void testFilter() throws Exception {
        assertEquals(16.5, slFilter.filter(3.0), 0.01);
        assertEquals(1778737.4550000003, slFilter.filter(323423.01), 0.01);
        assertEquals(-1.8116376712127987E10, slFilter.filter(-3.023423), 0.01);
        assertEquals(-1.9518097868128412E15, slFilter.filter(0.00000123423), 0.01);
    }

    /**
     * Method: filter(Double in)
     */
    @Test
    public void testFilterOutOfRange() throws Exception {
        assertEquals(16.5, slFilter.filter(3.0), 0.01);
        assertEquals(1778737.4550000003, slFilter.filter(323423.01), 0.01);
        assertEquals(-1.8116376712127987E10, slFilter.filter(-3.023423), 0.01);
        assertEquals(-1.9518097868128412E15, slFilter.filter(0.00000123423), 0.01);
    }

    /**
     * Method: reset()
     */
    @Test
    public void testReset() throws Exception {
        assertEquals(16.5, slFilter.filter(3.0), 0.01);
        assertEquals(1778737.4550000003, slFilter.filter(323423.01), 0.01);
        assertEquals(-1.8116376712127987E10, slFilter.filter(-3.023423), 0.01);
        assertEquals(-1.9518097868128412E15, slFilter.filter(0.00000123423), 0.01);
        slFilter.reset();
        assertEquals(0.0, slFilter.getInputSum(), 0.01);
        assertEquals(0.0, slFilter.getOutputSum(), 0.01);
    }

    /**
     * Method: reset(Double r)
     */
    @Test
    public void testResetR() throws Exception {
        assertEquals(16.5, slFilter.filter(3.0), 0.01);
        assertEquals(1778737.4550000003, slFilter.filter(323423.01), 0.01);
        assertEquals(-1.8116376712127987E10, slFilter.filter(-3.023423), 0.01);
        assertEquals(-1.9518097868128412E15, slFilter.filter(0.00000123423), 0.01);
        slFilter.reset(45.56);
        assertEquals(45.56, slFilter.getInputSum(), 0.01);
        assertEquals(45.56000012952512, slFilter.getOutputSum(), 0.01);
    }

    /**
     * Method: sumInput()
     */
    @Test
    public void testSumInput() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ScalarLinearFilter.getClass().getMethod("sumInput"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: sumOutput()
     */
    @Test
    public void testSumOutput() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ScalarLinearFilter.getClass().getMethod("sumOutput"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
