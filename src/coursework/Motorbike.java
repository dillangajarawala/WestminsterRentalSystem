/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

/**
 *
 * @author Dillan
 */
public class Motorbike extends Vehicle {
    
    public Motorbike(String plateNumber, String make) {
	super(plateNumber, make);
	colour = "black";
    }
    
    public Motorbike(String plateNumber, String make, String colour) {
	super(plateNumber, make, colour);
    }

    @Override
    public String getVehicleType() {
	return "Motorbike";
    }
}
