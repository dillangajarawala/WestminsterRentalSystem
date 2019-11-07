/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Dillan
 */
public class RentalGUI extends JFrame {
    
    public RentalGUI(ArrayList<Vehicle> list){
	setLayout(new BorderLayout(5, 10));
	this.add(createFilterPanel(), BorderLayout.WEST);
	this.add(createTablePanel(list), BorderLayout.CENTER);
	this.add(createAvailabilityPanel(), BorderLayout.EAST);
    }
    
    public JPanel createFilterPanel() {
	JPanel filter = new JPanel();
	filter.setLayout(new GridLayout(8, 2, 0, 10));
	JLabel title = new JLabel("Filter Vehicle List");
	JLabel placeholder = new JLabel("");
	filter.add(title);
//	filter.add(placeholder);
	
	JLabel param = new JLabel("Pick Filter Parameter");
	JComboBox picker = new JComboBox(new String[]{"Make", "Colour"});
	JLabel valueLbl = new JLabel("Enter Value:");
	JTextField value = new JTextField();
	
	JButton filterBtn = new JButton("Filter Vehicles");
	
	filter.add(param);
	filter.add(picker);
	filter.add(valueLbl);
	filter.add(value);
	filter.add(filterBtn);
	
	
	return filter;
    }
    
    public JPanel createTablePanel(ArrayList<Vehicle> list) {
	JPanel tbl = new JPanel();
	tbl.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
	JLabel title = new JLabel("Vehicle List");
	tbl.add(title);
	
	VehicleTableModel tableModel = new VehicleTableModel(list);
	JTable table = new JTable(tableModel);
	
	JScrollPane scrollPane = new JScrollPane(table);
	tbl.add(scrollPane);
	
	return tbl;
    }
    
    public JPanel createAvailabilityPanel() {
	JPanel avail = new JPanel();
	avail.setLayout(new GridLayout(8, 2, 0, 10));
	JLabel title = new JLabel("Check Availability");
	avail.add(title);
	avail.add(new JLabel());
	
	JTextField startDay = new JTextField(2);
	JLabel startDayLbl = new JLabel("Start day: (dd)");
	
	JTextField startMonth = new JTextField(2);
	JLabel startMonthLbl = new JLabel("Start month: (mm)");
	
	JTextField startYr = new JTextField(4);
	JLabel startYrLbl = new JLabel("Start year: (yyyy)");
	
	JTextField endDay = new JTextField(2);
	JLabel endDayLbl = new JLabel("End day: (dd)");
	
	JTextField endMonth = new JTextField(2);
	JLabel endMonthLbl = new JLabel("End month: (mm)");
	
	JTextField endYr = new JTextField(4);
	JLabel endYrLbl = new JLabel("End year: (yyyy)");
	
	JButton check = new JButton("Check Availability");
	
	avail.add(startDayLbl);
	avail.add(startDay);
	avail.add(startMonthLbl);
	avail.add(startMonth);
	avail.add(startYrLbl);
	avail.add(startYr);
	avail.add(endDayLbl);
	avail.add(endDay);
	avail.add(endMonthLbl);
	avail.add(endMonth);
	avail.add(endYrLbl);
	avail.add(endYr);
	avail.add(check);
	
	return avail;
    }
    
}
