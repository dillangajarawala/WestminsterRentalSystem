/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dillan
 */
public class WestminsterRentalVehicleManager implements RentalVehicleManager {
    private final ArrayList<Vehicle> vehiclesToRent;
    private final ArrayList<Schedule> rentalSchedules;

    public WestminsterRentalVehicleManager() {
	vehiclesToRent = new ArrayList<>();
	rentalSchedules = new ArrayList<>();
    }
    
    @Override
    public void addVehicle(Vehicle vehicleToAdd) {
	if (vehiclesToRent.size() == 50) {
	    System.out.println("Sorry, the rental parking lot is full. Please delete a vehicle from the system.");
	} else if (vehiclesToRent.size() < 50) {
	    vehiclesToRent.add(vehicleToAdd);
	    System.out.println("Vehicle successfully added.");
	}
    }

    @Override
    public void deleteVehicle(String plateNumber) {
	Vehicle toDelete = null;
	for (Vehicle v: vehiclesToRent) {
	    if (v.getPlateNumber().equals(plateNumber)) {
		toDelete = v;
	    }
	}
	
	if (toDelete != null) {
	    vehiclesToRent.remove(toDelete);
	    System.out.println("Vehicle with plate " + plateNumber + " successfully deleted from system");
	} else {
	    System.out.println("Vehicle with plate " + plateNumber + " does not exist in system");
	}
    }

    @Override
    public void printVehicles() {
	System.out.println();
	System.out.println("VEHICLE LIST:");
	ArrayList<Vehicle> sortedVehicles = this.vehiclesToRent;
	Collections.sort(sortedVehicles);
	for (Vehicle v: sortedVehicles) {
	    System.out.println(v);
	}
    }

    @Override
    public void saveVehicleList() throws IOException {
	PrintWriter writer = new PrintWriter("vehicles.txt");
	for (Vehicle v : this.vehiclesToRent) {
	    writer.println(v.toString());
	}
	writer.close();
    }

    @Override
    public ArrayList<Vehicle> filterVehicles(String param, String value) {
	ArrayList<Vehicle> filtered = new ArrayList<>();
	switch(param) {
	    case "Colour":
		for (Vehicle v: vehiclesToRent) {
		    if (v.getColour().equals(value)) {
			filtered.add(v);
		    }
		}
		
	    case "Make":
		for (Vehicle v: vehiclesToRent) {
		    if (v.getMake().equals(value)) {
			filtered.add(v);
		    }
		}
	}
	return filtered;
    }

    @Override
    public boolean checkAvailability(String plateNumber, Date start, Date end) {
	if (start.greaterThan(end)) {
	    System.out.println("Please choose a valid date range");
	    return false;
	}
	for (Schedule s: rentalSchedules) {
	    if (s.getVehicle().getPlateNumber().equals(plateNumber)) {
		if (Date.overlap(s.getPickUpDate(), s.getDropOffDate(), start, end)) {
		    return false;
		}
	    }
	}
	return true;
    }

    @Override
    public void bookVehicle(String plateNumber, Date pickUpDate, Date dropOffDate) {
	boolean booked = false;
	for (Vehicle v: vehiclesToRent) {
	    if (v.getPlateNumber().equals(plateNumber)) {
		rentalSchedules.add(new Schedule(v, pickUpDate, dropOffDate));
		booked = true;
	    }
	}
	if (booked) {
	    System.out.println("Vehicle with plate " + plateNumber + " successfully booked from " + pickUpDate.getDate() + " to " + dropOffDate.getDate() + ".");
	} else {
	    System.out.println("Vehicle with plate " + plateNumber + " does not exist in system");
	}
    }

    @Override
    public void launchGUI() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean launchMenu() {
	boolean exit = false;
	
	System.out.println("To Add a new Vehicle press 1");
	System.out.println("To Delete a Vehicle press 2");
	System.out.println("To Print the list of Vehicles press 3");
	System.out.println("To Save the list of Vehicles press 4");
	System.out.println("To launch the Customer Graphical User Interface press 5");
	System.out.println("To exit the console system press 6");
	
	Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
	
	switch(choice) {
	    case 1:
		System.out.println("Press 1 to add a Car");
		System.out.println("Press 2 to add a Motorbike");
		
		int vehicleType = s.nextInt();
		s.nextLine();
		
		System.out.println("Enter the plate number of the vehicle");
		String plateNumber = s.nextLine();
		
		System.out.println("Enter the colour of the vehicle");
		String colour = s.nextLine();
		
		System.out.println("Enter the make of the vehicle");
		String make = s.nextLine();
		
		switch(vehicleType) {
		    case 1:
			Map<Integer, String> carTypes = new HashMap<>();
			carTypes.put(1, "SUV");
			carTypes.put(2, "Sedan");
			carTypes.put(3, "Minivan");
			System.out.println("Enter 1 for SUV, 2 for Sedan, or 3 for Minivan.");
			int carType = s.nextInt();
			s.nextLine();
			Car c = new Car(plateNumber, make, carTypes.get(carType), colour);
			addVehicle(c);
			break;
		    case 2:
			Map<Integer, String> bikeTypes = new HashMap<>();
			bikeTypes.put(1, "Moped");
			bikeTypes.put(2, "Dirt Bike");
			bikeTypes.put(3, "Cruiser");
			System.out.println("Enter 1 for Moped, 2 for Dirt Bike, or 3 for Cruiser.");
			int bikeType = s.nextInt();
			s.nextLine();
			Motorbike m = new Motorbike(plateNumber, make, bikeTypes.get(bikeType), colour);
			addVehicle(m);
			break;	
		}
		System.out.println();
		break;
		
	    case 2:
		s.nextLine();
		System.out.println("Enter the plate number of the vehicle");
		String plateToDelete = s.nextLine();
		deleteVehicle(plateToDelete);
		System.out.println();
		break;
		
	    case 3:
		printVehicles();
		System.out.println();
		break;
		
	    case 4:
	    try {
		saveVehicleList();
	    } catch (IOException ex) {
		Logger.getLogger(WestminsterRentalVehicleManager.class.getName()).log(Level.SEVERE, null, ex);
	    }
		System.out.println();
		break;
		
	    case 5:
		launchGUI();
		break;
		
	    case 6:
		exit = true;
		break;
	}
	return exit;
    }
    
}
