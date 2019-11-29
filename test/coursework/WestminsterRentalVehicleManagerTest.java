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
public class WestminsterRentalVehicleManagerTest {
    WestminsterRentalVehicleManager rvm;
    
    public WestminsterRentalVehicleManagerTest() {
    }
    
    @Before
    public void setUp() {
	rvm = new WestminsterRentalVehicleManager();
    }
    
    @After
    public void tearDown() {
	rvm = null;
    }

    /**
     * Test of addVehicle method, of class WestminsterRentalVehicleManager.
     */
    @Test
    public void testAddVehicle() {
	System.out.print("Testing WestminsterRentalVehicleManager.addVehicle()...");
	Car c1 = new Car("plate1", "Honda", "sedan", "black");
	boolean added = rvm.addVehicle(c1);
	assertTrue(added);
	assertEquals(1, rvm.getVehiclesToRent().size());
	assertEquals(c1.getPlateNumber(), rvm.getVehiclesToRent().get(0).getPlateNumber());
	
	Motorbike m1 = new Motorbike("plate2", "Suzuki", "cruiser", "red");
	added = rvm.addVehicle(m1);
	assertTrue(added);
	assertEquals(2, rvm.getVehiclesToRent().size());
	assertEquals(m1.getPlateNumber(), rvm.getVehiclesToRent().get(1).getPlateNumber());
	
	Car c2 = new Car("plate2", "Ferrari", "sedan", "white");
	added = rvm.addVehicle(c2);
	assertFalse(added);
	assertEquals(2, rvm.getVehiclesToRent().size());
	
	for (int i = 3; i < 51; i++) {
	    added = rvm.addVehicle(new Car("plate" + Integer.toString(i), "Toyota", "SUV", "blue"));
	    assertTrue(added);
	}
	
	Motorbike m2 = new Motorbike("plate70", "Suzuki", "dirt bike", "green");
	added = rvm.addVehicle(m2);
	assertFalse(added);
	assertEquals(50, rvm.getVehiclesToRent().size());
	
	System.out.print("PASSED");
	System.out.println();
    }

    /**
     * Test of deleteVehicle method, of class WestminsterRentalVehicleManager.
     */
    @Test
    public void testDeleteVehicle() {
	System.out.print("Testing WestminsterRentalVehicleManager.deleteVehicle()...");
	Car c1 = new Car("plate1", "Honda", "sedan", "black");
	rvm.addVehicle(c1);
	boolean test = rvm.deleteVehicle("plate2");
	assertFalse(test);
	test = rvm.deleteVehicle("plate1");
	assertTrue(test);
	System.out.print("PASSED");
	System.out.println();
    }

//    /**
//     * Test of printVehicles method, of class WestminsterRentalVehicleManager.
//     */
//    @Test
//    public void testPrintVehicles() {
//	System.out.println("printVehicles");
//	WestminsterRentalVehicleManager instance = new WestminsterRentalVehicleManager();
//	instance.printVehicles();
//	// TODO review the generated test code and remove the default call to fail.
//	fail("The test case is a prototype.");
//    }

//    /**
//     * Test of saveVehicleList method, of class WestminsterRentalVehicleManager.
//     */
//    @Test
//    public void testSaveVehicleList() throws Exception {
//	System.out.println("saveVehicleList");
//	WestminsterRentalVehicleManager instance = new WestminsterRentalVehicleManager();
//	instance.saveVehicleList();
//	// TODO review the generated test code and remove the default call to fail.
//	fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of checkAvailability method, of class WestminsterRentalVehicleManager.
//     */
//    @Test
//    public void testCheckAvailability() {
//	System.out.println("checkAvailability");
//	String plateNumber = "";
//	Date start = null;
//	Date end = null;
//	WestminsterRentalVehicleManager instance = new WestminsterRentalVehicleManager();
//	boolean expResult = false;
//	boolean result = instance.checkAvailability(plateNumber, start, end);
//	assertEquals(expResult, result);
//	// TODO review the generated test code and remove the default call to fail.
//	fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of bookVehicle method, of class WestminsterRentalVehicleManager.
//     */
//    @Test
//    public void testBookVehicle() {
//	System.out.println("bookVehicle");
//	String plateNumber = "";
//	Date pickUpDate = null;
//	Date dropOffDate = null;
//	WestminsterRentalVehicleManager instance = new WestminsterRentalVehicleManager();
//	instance.bookVehicle(plateNumber, pickUpDate, dropOffDate);
//	// TODO review the generated test code and remove the default call to fail.
//	fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of launchGUI method, of class WestminsterRentalVehicleManager.
//     */
//    @Test
//    public void testLaunchGUI() {
//	System.out.println("launchGUI");
//	WestminsterRentalVehicleManager instance = new WestminsterRentalVehicleManager();
//	instance.launchGUI();
//	// TODO review the generated test code and remove the default call to fail.
//	fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of launchMenu method, of class WestminsterRentalVehicleManager.
//     */
//    @Test
//    public void testLaunchMenu() {
//	System.out.println("launchMenu");
//	WestminsterRentalVehicleManager instance = new WestminsterRentalVehicleManager();
//	boolean expResult = false;
//	boolean result = instance.launchMenu();
//	assertEquals(expResult, result);
//	// TODO review the generated test code and remove the default call to fail.
//	fail("The test case is a prototype.");
//    }
    
}
