package test;

import filter.IdentityFilter;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;

/** 
* IdentityFilter Tester. 
* 
* @author Shaun Howard
* @since <pre>Nov 18, 2014</pre> 
* @version 1.0 
*/ 
public class IdentityFilterTest { 

    IdentityFilter<Double, Double> idFilter;
    IdentityFilter<Double, Integer> badIdFilter;

@Before
public void before() throws Exception {
    idFilter = new IdentityFilter<>();
    badIdFilter = new IdentityFilter<>();
} 

/** 
* 
* Method: filter(A value)
* Structured Basis, Data flow, Good Data
* 
*/ 
@Test
public void testFilter() throws Exception { 
    assertEquals(100.0, idFilter.filter(100.0), .01);
    assertEquals(2341234624565785.34347056987058, idFilter.filter(2341234624565785.34347056987058), .01);
    assertEquals(-90865808., idFilter.filter(-90865808.), .01);
    assertEquals(.023423623456567678, idFilter.filter(.023423623456567678), .01);
} 

/** 
* 
* Method: reset(A value) 
* 
*/ 
@Test
public void testReset() throws Exception { 
//TODO: Test goes here... 
} 


} 