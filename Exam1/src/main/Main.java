/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import controller.DataDAO;
import controller.BestGpaUniversity;
import controller.FindName;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import model.University;

/**
 * 
 * @date Jun 19, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<University> a = new ArrayList<>();
        DataDAO.input(a);

        System.out.println("---Find Best in a University---");
        BestGpaUniversity.printBestGpaInUniversity(a);

        System.out.println("---Find average gpa in all University---");
        for (University u : a)
            System.out.println(u.getAverageGpa());
        System.out.println("---Find all students with input---");
        FindName.printName(a);
    }
}
