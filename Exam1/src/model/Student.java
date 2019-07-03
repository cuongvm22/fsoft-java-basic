/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 * 
 * @date Jun 19, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class Student {
    private String studentID;
    private String name;
    private int age;
    private double gpa;
    private University uni;

    public Student(String studentID, String name, int age, double gpa, University uni) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.uni = uni;
    }

    public Student() {
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", name=" + name + ", age=" + age + ", gpa=" + gpa + ", University=" + uni.getName() + '}';
    }

    
}
