/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
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
public class FindName {
    public static void printName(List<University> univ){
        System.out.println("Input name to find:");
        String name = DataDAO.s.nextLine();
        List<Student> stu = getStudents(univ, name);
        if (!stu.isEmpty())
            for (Student s : stu){
                System.out.println(s.toString());

            }
        else
            System.out.println("Name is not exit");
        
    }
    public static List<Student> getStudents(List<University> univ, String name){
        List<Student> students = new ArrayList<>();
        for (University uni : univ)
            for (Student st : uni.getStudents()){
                if (check(st, name)) students.add(st);
            }
        return students;
    }
    private static boolean check(Student s, String name){
        if (s.getName().contains(name)) return true;
        else return false;
    }
}
