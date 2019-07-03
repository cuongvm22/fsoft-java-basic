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
public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("Nguyen", "A", 12000.0);
        Employee e2 = new Employee("Nguyen", "B", 10000.0);
        
        System.out.println(e1.getLastName() + ": " + e1.getYearlySalary(0));
        System.out.println(e1.getLastName() + ": " + e1.getYearlySalary(10));
        System.out.println(e2.getLastName() + ": " + e2.getYearlySalary(0));
        System.out.println(e2.getLastName() + ": " + e2.getYearlySalary(10));
    }
}
