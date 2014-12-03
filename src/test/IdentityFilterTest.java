package test;

import filter.IdentityFilter;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

/** 
* A test class for the IdentityFilter class.
* The numbers chosen to filter demonstrate the
* class' support for signed and unsigned small, normal, and large-sized numbers but are
* arbitrarily chosen and do not precisely represent any cases that have issues.
* 
* @author Shaun Howard
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
* Type: Structured Basis, Data flow, Good Data
* 
*/ 
@Test
public void testFilter() throws Exception { 
    assertEquals(100.0, idFilter.filter(100.0), .01);
    assertEquals(2341234624565785.34347056987058, idFilter.filter(2341234624565785.34347056987058), .01);
    assertEquals(-90865808., idFilter.filter(-90865808.), .01);
    assertEquals(.023423623456567678, idFilter.filter(.023423623456567678), .01);
}

} 
