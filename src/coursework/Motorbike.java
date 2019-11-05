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
    private String type;
    
    public Motorbike(String plateNumber, String make) {
	super(plateNumber, make);
	colour = "black";
	this.type = "moped";
    }
    
    public Motorbike(String plateNumber, String make, String type) {
	super(plateNumber, make, "black");
	this.type = type;
    }
    
    public Motorbike(String plateNumber, String make, String type, String colour) {
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
    public String getVehicleType() {
	return "Motorbike";
    }
}
