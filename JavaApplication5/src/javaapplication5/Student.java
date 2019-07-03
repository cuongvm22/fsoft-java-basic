/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication5;

/**
 * 
 * @date Jun 26, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class Student {
    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", grade=" + grade + '}';
    }
    
}
