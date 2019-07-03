/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment3.ex2.model;

/**
 * 
 * @date Jun 24, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class HourlyEmployee extends Employee {
    
    private double wage;
    private double workingHours;
    @Override
    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return super.toString() + "{" + "wage=" + wage + ", workingHours=" + workingHours + '}';
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    public HourlyEmployee(double wage, double workingHours, String ssn, String firstName, String lastName) {
        super(ssn, firstName, lastName);
        this.wage = wage;
        this.workingHours = workingHours;
    }

    public HourlyEmployee(double wage, double workingHours, String ssn, String firstName, String lastName, String birthDate, String phone, String email) {
        super(ssn, firstName, lastName, birthDate, phone, email);
        this.wage = wage;
        this.workingHours = workingHours;
    }
    
    

}
