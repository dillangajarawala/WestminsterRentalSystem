/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import java.io.IOException;

/**
 *
 * @author Dillan
 */
public interface RentalVehicleManager {
    
    public abstract void addVehicle(Vehicle vehicleToAdd);
    
    public abstract void deleteVehicle(String plateNumber);
    
    public abstract void printVehicles();
    
    public abstract void saveVehicleList() throws IOException;
    
    public abstract boolean checkAvailability(String plateNumber, Date start, Date end);
    
    public abstract void bookVehicle(String plateNumber, Date pickUpDate, Date dropOffDate);
    
    public abstract void launchGUI();
    
    public abstract boolean launchMenu();
}
