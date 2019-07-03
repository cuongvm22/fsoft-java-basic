/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Student;
import model.University;

/**
 * 
 * @date Jun 19, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class DataDAO {
    static Scanner s;
    public static void input(List<University> univ) throws FileNotFoundException{
        s = new Scanner((System.in));
        System.out.println("Input university with form: id,location,name\nInput any think to exit");
        String[] result;
        while (true) {
            result = s.nextLine().split(",");
            if (result.length == 3){
                University u = new University(result[0].trim(), result[1].trim(), result[2].trim());
                if (!univ.contains(u)){
                     univ.add(u);
                }
            }
            else break;
        } 
        
        for (int i = 0; i < univ.size(); i++){
            System.out.print("Input student in " + univ.get(i).getName());
            System.out.println(" with form: id,name,age,gpa\nInput any think to exit");
            
            while (true) {
                result = s.nextLine().split(",");
                if (result.length == 4){
                    univ.get(i).addStudent(new Student(result[0], result[1], Integer.parseInt(result[2].trim()), Double.parseDouble(result[3]),univ.get(i)));
                }
                else break;
            } 
        }
        
    }
}
