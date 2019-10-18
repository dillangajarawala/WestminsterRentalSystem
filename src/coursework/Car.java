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
public class Car extends Vehicle{
    private String type;

    public Car(String plateNumber, String make) {
	super(plateNumber, make);
	colour = "black";
	type = "sedan";
    }
    
    public Car(String plateNumber, String make, String type) {
	super(plateNumber, make);
	colour = "black";
	this.type = type;
    }
    
    public Car(String plateNumber, String make, String type, String colour) {
	super(plateNumber, make, colour);
	this.type = type;
    }
    
    public String getType() {
	return this.type;
    }
    
    public void setType(String type) {
	this.type = type;
    }
    
    @Override
    public String toString() {
	return getVehicleType() + " of type " + this.type +  " with plate " + getPlateNumber() + ", make " + getMake() + ", and colour " + getColour() + ".";
    }
    
    @Override
    public String getVehicleType() {
	return "Car";
    }
    
}
