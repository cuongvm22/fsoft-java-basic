/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment3.ex2.service;

import assignment3.ex2.model.Department;
import assignment3.ex2.model.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @date Jun 24, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class EmployeeService {
    private static final EmployeeService instance = new EmployeeService();
    
    public static EmployeeService getInstance(){
        return EmployeeService.instance;
    }
    
    public List getEmployeeByDeparment(List<Department> dep, String departName){
        List result = new ArrayList();
        for (Department e : dep)
            if (e.getDepartmentName().equals(departName))
                result.addAll(e.getListOfEmployee());
        return result;
    }
    public List getEmployeeByName(List<Department> dep, String employeeName){
        List result = new ArrayList();
        for (Department e : dep)
            for (Employee el : e.getListOfEmployee())
                if ((el.getFirstName() + " " + el.getLastName() ).contains(employeeName))
                    result.add(el);
        return result;
    }
}
