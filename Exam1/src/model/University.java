/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @date Jun 19, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class University{
    private String id;
    private String location;
    private String name;
    private List<Student> students;

    public University(String id, String location, String name) {
        this.id = id;
        this.location = location;
        this.name = name;
        this.students = new ArrayList<Student>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public Student getBestGpa(){
        Student s = new Student();
        double maxGpa = Double.MIN_VALUE;
        
        for (Student el : students){
            if (el.getGpa() > maxGpa){
                s = el;
                maxGpa = el.getGpa();
            }
        }
        return s;
    }
    
    public double getAverageGpa(){
        if (this.getStudents().isEmpty()) return 0;
        double sum = 0;
        for (Student s : this.getStudents())
            sum += s.getGpa();
        return sum/(double) this.getStudents().size();
    }
    
    public void addStudent(Student s){
        this.students.add(s);
    }

    @Override
    public String toString() {
        return "University{" + "id=" + id + ", location=" + location + ", name=" + name+ "}"; 
    }


    @Override
    public boolean equals(Object o) {
        if (this.toString().equals(o.toString()))
            return true;
        return false;
    }
    
}
