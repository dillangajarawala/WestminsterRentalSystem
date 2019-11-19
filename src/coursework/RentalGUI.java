/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;

/**
 *
 * @author Dillan
 */
public class RentalGUI extends JFrame {
    private JComboBox picker;
    private JTextField value;
    private JButton filterBtn;
    private VehicleTableModel tableModel;
    private JTable table;
    private TableRowSorter<TableModel> rowSorter;
    
    private JTextField startDay;
    private JTextField startMonth;
    private JTextField startYr;
    private JTextField endDay;
    private JTextField endMonth;
    private JTextField endYr;
    private JButton check;
    
    
    public RentalGUI(ArrayList<Vehicle> list){
	setLayout(new BorderLayout(5, 10));
	this.add(createFilterPanel(), BorderLayout.WEST);
	this.add(createTablePanel(list), BorderLayout.CENTER);
	this.add(createAvailabilityPanel(), BorderLayout.EAST);
    }
    
    public JPanel createFilterPanel() {
	JPanel filter = new JPanel();
	filter.setBackground(Color.BLUE);
	filter.setLayout(new GridLayout(8, 2, 0, 10));
	JLabel title = new JLabel("Filter Vehicle List");
	title.setForeground(Color.WHITE);
	JLabel placeholder = new JLabel("");
	filter.add(title);
	filter.add(placeholder);
	
	JLabel param = new JLabel("Pick Filter Parameter");
	param.setForeground(Color.WHITE);
	this.picker = new JComboBox(new String[]{"Select", "Type", "Make", "Colour"});
	JLabel placeholder2 = new JLabel("");
	JLabel valueLbl = new JLabel("Enter Value:");
	valueLbl.setForeground(Color.WHITE);
	this.value = new JTextField();
	
	this.filterBtn = new JButton("Filter Vehicles");
	FilterHandler filterHandle = new FilterHandler();
	this.filterBtn.addActionListener(filterHandle);
	
	filter.add(param);
	filter.add(this.picker);
	filter.add(placeholder2);
	filter.add(valueLbl);
	filter.add(this.value);
	filter.add(this.filterBtn);
	
	
	return filter;
    }
    
    public JPanel createTablePanel(ArrayList<Vehicle> list) {
	JPanel tbl = new JPanel();
	tbl.setBackground(Color.BLUE);
	tbl.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
	JLabel title = new JLabel("Vehicle List");
	title.setForeground(Color.WHITE);
	tbl.add(title);
	
	this.tableModel = new VehicleTableModel(list);
	this.table = new JTable(this.tableModel);
	this.rowSorter = new TableRowSorter<>(this.table.getModel());
	this.table.setRowSorter(this.rowSorter);
	
	table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer(){
	    Color originalColor = null;
	    
	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		Component renderer;
		renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		if (value == "Car") {
		    renderer.setBackground(Color.GREEN);
		} else {
		    renderer.setBackground(Color.CYAN);
		}
		return renderer;
	    }
	});
	
	JScrollPane scrollPane = new JScrollPane(table);
	tbl.add(scrollPane);
	
	return tbl;
    }
    
    public JPanel createAvailabilityPanel() {
	JPanel avail = new JPanel();
	avail.setBackground(Color.BLUE);
	avail.setLayout(new GridLayout(8, 2, 0, 10));
	JLabel title = new JLabel("Check Availability");
	title.setForeground(Color.WHITE);
	avail.add(title);
	avail.add(new JLabel());
	
	this.startDay = new JTextField(2);
	JLabel startDayLbl = new JLabel("Start day: (dd)");
	startDayLbl.setForeground(Color.WHITE);
	
	this.startMonth = new JTextField(2);
	JLabel startMonthLbl = new JLabel("Start month: (mm)");
	startMonthLbl.setForeground(Color.WHITE);
	
	this.startYr = new JTextField(4);
	JLabel startYrLbl = new JLabel("Start year: (yyyy)");
	startYrLbl.setForeground(Color.WHITE);
	
	this.endDay = new JTextField(2);
	JLabel endDayLbl = new JLabel("End day: (dd)");
	endDayLbl.setForeground(Color.WHITE);
	
	this.endMonth = new JTextField(2);
	JLabel endMonthLbl = new JLabel("End month: (mm)");
	endMonthLbl.setForeground(Color.WHITE);
	
	this.endYr = new JTextField(4);
	JLabel endYrLbl = new JLabel("End year: (yyyy)");
	endYrLbl.setForeground(Color.WHITE);
	
	this.check = new JButton("Check Availability");
	RentalHandler rentalHandle = new RentalHandler();
	this.check.addActionListener(rentalHandle);
	
	avail.add(startDayLbl);
	avail.add(this.startDay);
	avail.add(startMonthLbl);
	avail.add(this.startMonth);
	avail.add(startYrLbl);
	avail.add(this.startYr);
	avail.add(endDayLbl);
	avail.add(this.endDay);
	avail.add(endMonthLbl);
	avail.add(this.endMonth);
	avail.add(endYrLbl);
	avail.add(this.endYr);
	avail.add(check);
	
	return avail;
    }
    
    private class FilterHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (picker.getSelectedItem() == "Type") {
		rowSorter.setRowFilter(RowFilter.regexFilter(value.getText(), 0));
	    } else if (picker.getSelectedItem() == "Make") {
		rowSorter.setRowFilter(RowFilter.regexFilter(value.getText(), 2));
	    } else if (picker.getSelectedItem() == "Colour") {
		rowSorter.setRowFilter(RowFilter.regexFilter(value.getText(), 4));
	    }
 	}
    
    }
    
    private class RentalHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    try {
		int startD = Integer.parseInt(startDay.getText());
		int startM = Integer.parseInt(startMonth.getText());
		int startY = Integer.parseInt(startYr.getText());
		int endD = Integer.parseInt(endDay.getText());
		int endM = Integer.parseInt(endMonth.getText());
		int endY = Integer.parseInt(endYr.getText());
		if (Date.couldBeValid(startD, startM, startY) && Date.couldBeValid(endD, endM, endY)) {
		    int row = table.getSelectedRow();
		    String value = table.getModel().getValueAt(row, 1).toString();
//		    boolean available = 
//		    System.out.println(value);
		} else {
		    JOptionPane.showMessageDialog(null, "At least one date is invalid. Make sure your dates are both valid.");
		}
	    } catch (NumberFormatException agh) {
		JOptionPane.showMessageDialog(null, "Not all your numbers are valid. Please enter valid numbers.");
	    }
	}
	
    }
    
}
