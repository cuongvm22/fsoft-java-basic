/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment3.main;

import assignment3.IO.IO;
import assignment3.ex2.model.Department;
import assignment3.ex2.model.Employee;
import assignment3.ex2.service.DepartmentService;
import assignment3.ex2.service.EmployeeService;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @date Jun 24, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class MainEx2 {
    public static void main(String[] args) {
        IO io = new IO();
        List<Department> a = new ArrayList();
        a = io.getDepartment();
        for (Department e : a)
            io.getEmployee(e);
        for (Department e : a){
            System.out.println(e.getDepartmentName());
            DepartmentService.getInstance().classifyEmployee(e);
            System.out.println("");
        }
        
        System.out.println("Input DepartmentName to find:");
        List<Employee> b = EmployeeService.getInstance().getEmployeeByDeparment(a, io.getLine());
        for (Employee el : b)
            el.display();
        
        System.out.println("Input EmployeeName to find:");
        b = EmployeeService.getInstance().getEmployeeByName(a, io.getLine());
        for (Employee e : b)
            e.display();
        
        DepartmentService.getInstance().report(a);
    }
}
