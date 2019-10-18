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
}
