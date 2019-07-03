/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment3.ex2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @date Jun 24, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class Department {
    private String departmentName;
    private List<Employee> listOfEmployee;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department() {
        this("", new ArrayList());
    }    
    
    public Department(String departmentName, List listOfEmployee) {
        this.departmentName = departmentName;
        this.listOfEmployee = listOfEmployee;
    }

    public Department(String departmentName) {
        this(departmentName, new ArrayList());
    }
    
    public void addEmployee(Employee e){
        this.listOfEmployee.add(e);
    }
    
    public void display(){
        System.out.println("Department: " + this.getDepartmentName());
        for (Employee e : listOfEmployee)
            e.display();
    }

    public List<Employee> getListOfEmployee() {
        return listOfEmployee;
    }
    
}
