package test;

import exception.EmptyListException;
import exception.IncorrectSizeException;
import exception.NullValueException;
import filter.AveragingFilterN;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * AveragingFilterN Tester.
 *
 * @author Shaun Howard
 * @version 1.0
 * @since <pre>Nov 18, 2014</pre>
 */
public class AveragingFilterNTest {

    AveragingFilterN avgFilterNomimal, avgFilterNegativeBoundary,
            avgFilterAtBoundary, avgFilterPositiveBoundary;
    static final int MIN_SIZE = -10;
    static final int BOUND = 0;
    static final int LARGE_SIZE = 1000000;
    static final int NOM_SIZE = 10;

    @Before
    public void before() throws Exception {
        avgFilterNomimal = new AveragingFilterN(NOM_SIZE);
        avgFilterNegativeBoundary = new AveragingFilterN(MIN_SIZE);
        avgFilterAtBoundary = new AveragingFilterN(BOUND);
        avgFilterPositiveBoundary = new AveragingFilterN(LARGE_SIZE);
    }

    /**
     * Method: filter(Double value)
     * Structured Basis
     */
    @Test
    public void testFilterStructure() throws Exception {
        assertEquals(300.0, avgFilterNomimal.filter(300.0), 0.01);
    }

    /**
     * Method: filter(Double value)
     * Good data
     */
    @Test
    public void testFilterGoodData() throws Exception {
        assertEquals(300.0, avgFilterNomimal.filter(300.0), 0.01);
        assertEquals(300.0, avgFilterNomimal.filter(300.0), 0.01);
        assertEquals(4.104113763733744E10, avgFilterNomimal.filter(123123412312.012312312312), 0.01);
        assertEquals(3.078085322806164E10, avgFilterNomimal.filter(0.234234234656450), 0.01);
        assertEquals(2.397555346235356E10, avgFilterNomimal.filter(-3245645600.4787560), 0.01);
    }

    /**
     * Method: filter(Double value)
     * Bad data
     */
    @Test(expected = NullValueException.class)
    public void testFilterBadData() throws Exception {
        avgFilterNomimal.filter(null);
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
                avgFilterPositiveBoundary.filter(value);
            } else {
                assertEquals(2.6726761760069965E18, avgFilterPositiveBoundary.filter(value), .01);
            }
        }
    }

    /**
     * Method: maintainN()
     * Lower boundary
     */
    @Test(expected = IncorrectSizeException.class)
    public void testMaintainNNegBoundary() throws Exception {
        avgFilterNegativeBoundary.getValues().add(23423.3);
        avgFilterNegativeBoundary.getValues().add(23423.3234);
        avgFilterNegativeBoundary.getValues().add(25653.3);
        avgFilterNegativeBoundary.maintainN();
    }

    /**
     * Method: maintainN()
     * At boundary, structured basis
     */
    @Test
    public void testMaintainNAtBoundaryStructure() throws Exception {
        avgFilterAtBoundary.getValues().add(23423.3);
        avgFilterAtBoundary.maintainN();
        assertTrue(avgFilterAtBoundary.getValues().isEmpty());
    }

    /**
     * Method: maintainN()
     * At boundary, structured basis
     */
    @Test(expected = EmptyListException.class)
    public void testMaintainNAtBoundaryException() throws Exception {
        avgFilterAtBoundary.maintainN();
    }

    /**
     * Method: maintainN()
     * Higher boundary, structured basis
     */
    @Test
    public void testMaintainNHighBoundary() throws Exception {
        avgFilterPositiveBoundary.getValues().add(23423423.5423);
        avgFilterPositiveBoundary.maintainN();
        assertEquals(1, avgFilterPositiveBoundary.getValues().size());
    }

    /**
     * Method: reset()
     * Structured basis
     */
    @Test
    public void testReset() throws Exception {
        avgFilterPositiveBoundary.getValues().add(23423423.5423);
        avgFilterPositiveBoundary.reset();
        assertTrue(avgFilterPositiveBoundary.getValues().isEmpty());
    }


    /**
     * Method: average()
     */
    @Test
    public void testAverage() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = AveragingFilterN.getClass().getMethod("average"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
