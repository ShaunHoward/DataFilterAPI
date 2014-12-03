package test;

import exception.EmptyListException;
import exception.IncorrectSizeException;
import exception.NullValueException;
import filter.MinFilterN;
import org.junit.Test; 
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/** 
* A test class for the MinFilterN class.
* The numbers chosen to filter demonstrate the
* class' support for signed and unsigned small, normal, and large-sized numbers but are
* arbitrarily chosen and do not precisely represent any cases that have issues.
* 
* @author Shaun Howard
*/ 
public class MinFilterNTest {
    MinFilterN<Double, Double> minFilterNomimal, minFilterNegativeBoundary,
            minFilterAtBoundary, minFilterPositiveBoundary;
    static final int MIN_SIZE = -10;
    static final int BOUND = 0;
    static final int LARGE_SIZE = 1000;
    static final int NOM_SIZE = 5;

    @Before
    public void before() throws Exception {
        minFilterNomimal = new MinFilterN(NOM_SIZE);
        minFilterNegativeBoundary = new MinFilterN(MIN_SIZE);
        minFilterAtBoundary = new MinFilterN(BOUND);
        minFilterPositiveBoundary = new MinFilterN(LARGE_SIZE);
    }

    /**
     * Method: filter(Double value)
     * Type: Structured Basis
     */
    @Test
    public void testFilterStructure() throws Exception {
        assertEquals(300.0, minFilterNomimal.filter(300.0), 0.01);
    }

    /**
     * Method: filter(Double value)
     * Type: Good data
     */
    @Test
    public void testFilterGoodData() throws Exception {
        assertEquals(300.0, minFilterNomimal.filter(300.0), 0.01);
        assertEquals(300.0, minFilterNomimal.filter(300.0), 0.01);
        assertEquals(300.0, minFilterNomimal.filter(123123412312.012312312312), 0.01);
        assertEquals(0.234234234656450, minFilterNomimal.filter(0.234234234656450), 0.01);
        assertEquals(-3245645600.4787560, minFilterNomimal.filter(-3245645600.4787560), 0.01);
    }

    /**
     * Method: filter(Double value)
     * Type: Bad data
     */
    @Test(expected = NullValueException.class)
    public void testFilterBadData() throws Exception {
        minFilterNomimal.filter(null);
    }

    /**
     * Method: filter(Double value)
     * Type: Stress
     */
    @Test
    public void testFilterStress() throws Exception {
        double value = 0.0;
        for (int i = 0; i < LARGE_SIZE; i++) {
            value += (double) (2 * i) + 5345346340000.0235968966456;

            if (i < LARGE_SIZE - 1) {
                minFilterPositiveBoundary.filter(value);
            } else {
                assertEquals(5345346340000.0235968966456, minFilterPositiveBoundary.filter(value), .01);
            }
        }
    }

    /**
     * Method: maintainN()
     * Type: Lower boundary
     */
    @Test(expected = IncorrectSizeException.class)
    public void testMaintainNNegBoundary() throws Exception {
        minFilterNegativeBoundary.getValues().add(23423.3);
        minFilterNegativeBoundary.getValues().add(23423.3234);
        minFilterNegativeBoundary.getValues().add(25653.3);
        minFilterNegativeBoundary.maintainN();
    }

    /**
     * Method: maintainN()
     * Type: At boundary, structured basis
     */
    @Test
    public void testMaintainNAtBoundaryStructure() throws Exception {
        minFilterAtBoundary.getValues().add(23423.3);
        minFilterAtBoundary.maintainN();
        assertTrue(minFilterAtBoundary.getValues().isEmpty());
    }

    /**
     * Method: maintainN()
     * Type: At boundary, structured basis
     */
    @Test(expected = EmptyListException.class)
    public void testMaintainNAtBoundaryException() throws Exception {
        minFilterAtBoundary.maintainN();
    }

    /**
     * Method: maintainN()
     * Type: Higher boundary, structured basis
     */
    @Test
    public void testMaintainNHighBoundary() throws Exception {
        minFilterPositiveBoundary.getValues().add(23423423.5423);
        minFilterPositiveBoundary.maintainN();
        assertEquals(1, minFilterPositiveBoundary.getValues().size());
    }

    /**
     * Method: reset()
     * Type: Structured basis
     */
    @Test
    public void testReset() throws Exception {
        minFilterPositiveBoundary.getValues().add(23423423.5423);
        minFilterPositiveBoundary.reset(0.0);
        assertEquals(1, minFilterPositiveBoundary.getValues().size());
    }

/** 
* 
* Method: min() 
* 
*/ 
@Test
public void testMin() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = MinFilterN.getClass().getMethod("min"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
