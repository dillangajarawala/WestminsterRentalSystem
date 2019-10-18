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
public abstract class Vehicle {
    protected String plateNumber;
    protected String make;
    protected String colour;
    
    public Vehicle(String plateNumber, String make) {
        this.plateNumber = plateNumber;
	this.make = make;
    }
    
    public Vehicle(String plateNumber, String make, String colour) {
        this.plateNumber = plateNumber;
	this.make = make;
	this.colour = colour;
    }
    
    public void setPlateNumber(String plateNumber) {
	this.plateNumber = plateNumber;
    }
    
    public String getPlateNumber() {
	return this.plateNumber;
    }
    
    public void setMake(String make) {
	this.make = make;
    }
    
    public String getMake() {
	return this.make;
    }
    
    public void setColour(String colour) {
	this.colour = colour;
    }
    
    public String getColour() {
	return this.colour;
    }
    
    public abstract String getVehicleType();
    
    @Override
    public String toString() {
	return getVehicleType() + " with plate " + getPlateNumber() + ", make " + getMake() + ", and colour " + getColour() + ".";
    }
    
    
}
