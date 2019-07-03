/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.main;

import assignment5.io.Input;
import assignment5.models.Airport;
import assignment5.services.MenuServices;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuongvm
 */
public class Assignment5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Airport> a = new ArrayList();
        MenuServices.getInstance().getStartMenu(a);
        Input.getInstance().close();
    }
    
}
