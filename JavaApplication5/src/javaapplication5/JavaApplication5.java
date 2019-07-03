/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuongvm
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Student> a = new ArrayList();
        Student[] b = new Student[3];
        b[0] = (new Student("Hugo", 6));
        b[1] = (new Student("Hugo1", 7));
        b[2] = (new Student("Hugo2", 8));
        
        a.add(new Student("Hugo", 6));
        a.add(new Student("Hugo1", 7));
        a.add(new Student("Hugo2", 8));
        
        System.out.println(a);
        System.out.println(b);
    }
    
}
