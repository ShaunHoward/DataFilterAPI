package test;

import exception.EmptyListException;
import exception.IncorrectSizeException;
import exception.NullValueException;
import filter.MaxFilterN;
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/** 
* MaxFilterN Tester. 
* 
* @author Shaun Howard
* @since <pre>Nov 18, 2014</pre> 
* @version 1.0 
*/ 
public class MaxFilterNTest {
    MaxFilterN<Double, Double> maxFilterNomimal, maxFilterNegativeBoundary,
            maxFilterAtBoundary, maxFilterPositiveBoundary;
    static final int MIN_SIZE = -10;
    static final int BOUND = 0;
    static final int LARGE_SIZE = 1000;
    static final int NOM_SIZE = 5;

    @Before
    public void before() throws Exception {
        maxFilterNomimal = new MaxFilterN(NOM_SIZE);
        maxFilterNegativeBoundary = new MaxFilterN(MIN_SIZE);
        maxFilterAtBoundary = new MaxFilterN(BOUND);
        maxFilterPositiveBoundary = new MaxFilterN(LARGE_SIZE);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: filter(Double value)
     * Structured Basis
     */
    @Test
    public void testFilterStructure() throws Exception {
        assertEquals(300.0, maxFilterNomimal.filter(300.0), 0.01);
    }

    /**
     * Method: filter(Double value)
     * Good data
     */
    @Test
    public void testFilterGoodData() throws Exception {
        assertEquals(300.0, maxFilterNomimal.filter(300.0), 0.01);
        assertEquals(300.0, maxFilterNomimal.filter(300.0), 0.01);
        assertEquals(123123412312.012312312312, maxFilterNomimal.filter(123123412312.012312312312), 0.01);
        assertEquals(123123412312.012312312312, maxFilterNomimal.filter(0.234234234656450), 0.01);
        assertEquals(123123412312.012312312312, maxFilterNomimal.filter(-3245645600.4787560), 0.01);
    }

    /**
     * Method: filter(Double value)
     * Bad data
     */
    @Test(expected = NullValueException.class)
    public void testFilterBadData() throws Exception {
        maxFilterNomimal.filter(null);
    }

    /**
     * Method: filter(Double value)
     * Stress
     */
    @Test
    public void testFilterStress() throws Exception {
        double value = 0.0;
        for (int i = 0; i < LARGE_SIZE; i++) {
            value += (double) (2 * i) + 5345346340000.0235968966456;

            if (i < LARGE_SIZE - 1) {
                maxFilterPositiveBoundary.filter(value);
            } else {
                assertEquals(value, maxFilterPositiveBoundary.filter(value), .01);
            }
        }
    }

    /**
     * Method: maintainN()
     * Lower boundary
     */
    @Test(expected = IncorrectSizeException.class)
    public void testMaintainNNegBoundary() throws Exception {
        maxFilterNegativeBoundary.getValues().add(23423.3);
        maxFilterNegativeBoundary.getValues().add(23423.3234);
        maxFilterNegativeBoundary.getValues().add(25653.3);
        maxFilterNegativeBoundary.maintainN();
    }

    /**
     * Method: maintainN()
     * At boundary, structured basis
     */
    @Test
    public void testMaintainNAtBoundaryStructure() throws Exception {
        maxFilterAtBoundary.getValues().add(23423.3);
        maxFilterAtBoundary.maintainN();
        assertTrue(maxFilterAtBoundary.getValues().isEmpty());
    }

    /**
     * Method: maintainN()
     * At boundary, structured basis
     */
    @Test(expected = EmptyListException.class)
    public void testMaintainNAtBoundaryException() throws Exception {
        maxFilterAtBoundary.maintainN();
    }

    /**
     * Method: maintainN()
     * Higher boundary, structured basis
     */
    @Test
    public void testMaintainNHighBoundary() throws Exception {
        maxFilterPositiveBoundary.getValues().add(23423423.5423);
        maxFilterPositiveBoundary.maintainN();
        assertEquals(1, maxFilterPositiveBoundary.getValues().size());
    }

    /**
     * Method: reset()
     * Structured basis
     */
    @Test
    public void testReset() throws Exception {
        maxFilterPositiveBoundary.getValues().add(23423423.5423);
        maxFilterPositiveBoundary.reset(0.0);
        assertEquals(1, maxFilterPositiveBoundary.getValues().size());
    }

/**
* 
* Method: max() 
* 
*/ 
@Test
public void testMax() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = MaxFilterN.getClass().getMethod("max"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
