/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dillan
 */
public class DateTest {
    Date date1;
    Date date2;
    
    public DateTest() {
    }
    
    @Before
    public void setUp() {
	date1 = new Date(9, 1, 2020);
	date2 = new Date(21, 12, 2021);
    }
    
    @After
    public void tearDown() {
	date1 = null;
	date2 = null;
    }

    /**
     * Test of getDate method, of class Date.
     */
    @Test
    public void testGetDate() {
	System.out.print("Testing getDate()...");
	String date1Result = "09/01/2020";
	String date2Result = "21/12/2021";
	assertEquals(date1Result, date1.getDate());
	assertEquals(date2Result, date2.getDate());
	System.out.print("PASSED");
	System.out.println();
    }

    /**
     * Test of withinRange method, of class Date.
     */
    @Test
    public void testWithinRange() {
	System.out.print("Testing withinRange()...");
	Date within = new Date(6, 3, 2020);
	Date notWithin = new Date(8, 1, 2020);
	assertTrue(within.withinRange(date1, date2));
	assertFalse(notWithin.withinRange(date1, date2));
	System.out.print("PASSED");
	System.out.println();
    }

    /**
     * Test of greaterThan method, of class Date.
     */
    @Test
    public void testGreaterThan() {
	System.out.print("Testing greaterThan()...");
	Date greaterThanOne = new Date(10, 1, 2020);
	assertTrue(greaterThanOne.greaterThan(date1));
	assertFalse(greaterThanOne.greaterThan(date2));
	System.out.print("PASSED");
	System.out.println();
    }

    /**
     * Test of lessThan method, of class Date.
     */
    @Test
    public void testLessThan() {
	System.out.print("Testing lessThan()...");
	Date lessThanOne = new Date(13, 11, 2020);
	assertTrue(lessThanOne.lessThan(date2));
	assertFalse(lessThanOne.lessThan(date1));
	System.out.print("PASSED");
	System.out.println();
    }

    /**
     * Test of overlap method, of class Date.
     */
    @Test
    public void testOverlap() {
	System.out.println("overlap");
	Date start1 = null;
	Date end1 = null;
	Date start2 = null;
	Date end2 = null;
	boolean expResult = false;
	boolean result = Date.overlap(start1, end1, start2, end2);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

//    /**
//     * Test of couldBeValid method, of class Date.
//     */
//    @Test
//    public void testCouldBeValid() {
//	System.out.println("couldBeValid");
//	int day = 0;
//	int month = 0;
//	int year = 0;
//	boolean expResult = false;
//	boolean result = Date.couldBeValid(day, month, year);
//	assertEquals(expResult, result);
//	// TODO review the generated test code and remove the default call to fail.
//	fail("The test case is a prototype.");
//    }
    
}
