/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment5.services;

/**
 * 
 * @date Jul 1, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class CheckServices {
    private static CheckServices instance;

    private CheckServices() {
    }
    
    public static CheckServices getInstance(){
        instance = new CheckServices();
        return instance;
    }
    
    public int checkID(String id){
        if (id.matches("^AP\\d{5}"))
            return 1;
        else if (id.matches("^FW\\d{5}"))
            return 2;
        else if (id.matches("^RW\\d{5}"))
            return 3;
        else{
            return -1;
        }
    }
    
    public boolean checkModel(String id){
        return (id.length() <= 40)? true:false;
    }
    public boolean checkValue(double maxTake, double empty){
        return (maxTake <= 1.5 * empty)? true:false;
    }
}
