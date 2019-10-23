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
public class Date {
    private int day;
    private int month;
    private int year;
    
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public void setDay(int day) {
        this.day = day;
    }
    
    public void setMonth(int month) {
        this.month = month;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public int getDay() {
        return this.day;
    }
    
    public int getMonth() {
        return this.month;
    }
    
    public int getYear() {
        return this.year;
    }
    
    @Override
    public String toString() {
        return "Date [ day = " + this.day + ", month = " + this.month + ", year = " + this.year + "]";
    }
    
    public String getDate() {
        if (this.day < 9) {
            return "0" + this.day + "/" + this.month + "/" + this.year;
        }
        else {
            return this.day + "/" + this.month + "/" + this.year;
        }
    }
    
    public boolean withinRange(Date date1, Date date2) {
	if (year >= date1.getYear() && year <= date2.getYear()) {
	    if (month >= date1.getMonth() && month <= date2.getMonth()) {
		if (day >= date1.getDay() && day <= date2.getDay()) {
		    return true;
		}
	    }
	}
	return false;
    }
    
    public boolean greaterThan(Date comparison) {
	if (year > comparison.getYear()) {
	    return true;
	} else if (year == comparison.getYear() && month > comparison.getMonth()) {
	    return true;
	} else if (year == comparison.getYear() && month == comparison.getMonth() && day > comparison.getDay()) {
	    return true;
	}
	return false;
    }
    
    public boolean lessThan(Date comparison) {
	if (year < comparison.getYear()) {
	    return true;
	} else if (year == comparison.getYear() && month < comparison.getMonth()) {
	    return true;
	} else if (year == comparison.getYear() && month == comparison.getMonth() && day < comparison.getDay()) {
	    return true;
	}
	return false;
    }
    
    public static boolean overlap(Date start1, Date end1, Date start2, Date end2) {
	if (start2.withinRange(start1, end1) || end2.withinRange(start1, end1)) {
	    return true;
	} else if (start2.lessThan(start1) && end2.greaterThan(end1)) {
	    return true;
	}
	return false;
    }
}
