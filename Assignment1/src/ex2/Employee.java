/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ex2;

/**
 * 
 * @date Jun 18, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class Employee {
    private String firstName;
    private String lastName;
    private Double monthlySalary;

    public Employee(String firstName, String lastName, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlySalary = (salary >= 0)? salary: 0;
    }

    public Employee() {
        new Employee("", "", 0.0);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getYearlySalary(int raise){
        return (getMonthlySalary() * (12 + (double)(raise)/100));
    }
    
    
    
    
}
