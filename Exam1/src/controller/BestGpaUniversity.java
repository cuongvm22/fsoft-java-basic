/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;
import model.Student;
import model.University;

/**
 * 
 * @date Jun 19, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class BestGpaUniversity {
    
    public static void printBestGpaInUniversity(List<University> univs){
        System.out.println("Input University's name:");
        String name = DataDAO.s.nextLine();
        Student temp = getBestGpaInUniversity(univs, name);
        if (temp == null)
            System.out.println("This University not exists");
        else 
            System.out.println(temp.toString());
        
    }
    
    public static Student getBestGpaInUniversity(List<University> univs, String nameUniversity ){
        for (University el : univs)
            if (el.getName().equalsIgnoreCase(nameUniversity))
                return el.getBestGpa();
        return null;
    }
}
