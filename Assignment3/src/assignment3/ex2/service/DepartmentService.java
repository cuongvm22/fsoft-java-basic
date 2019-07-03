/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment3.ex2.service;

import assignment3.ex2.model.Department;
import assignment3.ex2.model.Employee;
import java.util.List;

/**
 * 
 * @date Jun 24, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class DepartmentService {
    
    private static final DepartmentService instance = new DepartmentService();
    
    public static DepartmentService getInstance(){
        return DepartmentService.instance;
    }
    
    public void classifyEmployee(Department a){
        for (Employee e : a.getListOfEmployee()){
            e.display();
            System.out.println(e.getClass().getSimpleName());
        }
    }
    public void report(List<Department> listDe){
        for (Department e : listDe )
            System.out.println(e.getDepartmentName() + " - " + e.getListOfEmployee().size() + " Employees");
    }
}
