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
public class SalariedEmployee extends Employee{
    
    private double commissionRate;
    private double grossSales;
    private double basicSalary;

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }
    
    @Override
    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return super.toString() + "{" + "commissionRate=" + commissionRate + ", grossSales=" + grossSales + ", basicSalary=" + basicSalary + '}';
    }

    public SalariedEmployee(double commissionRate, double grossSales, double basicSalary, String ssn, String firstName, String lastName) {
        super(ssn, firstName, lastName);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
        this.basicSalary = basicSalary;
    }

    public SalariedEmployee(double commissionRate, double grossSales, double basicSalary, String ssn, String firstName, String lastName, String birthDate, String phone, String email) {
        super(ssn, firstName, lastName, birthDate, phone, email);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
        this.basicSalary = basicSalary;
    }
    
    
    
}
