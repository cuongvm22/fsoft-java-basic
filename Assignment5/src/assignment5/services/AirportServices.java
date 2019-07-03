/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment5.services;

import assignment5.io.Input;
import assignment5.models.Airplane;
import assignment5.models.Airport;
import assignment5.models.FixedWing;
import assignment5.models.Helicopter;

/**
 * 
 * @date Jul 1, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class AirportServices {
    
    public static AirportServices instance;
    
    public static AirportServices getInstance(){
        AirportServices.instance = new AirportServices();
        return AirportServices.instance;
    }

    private AirportServices() {
    }
    
    
    public Airport create(){
        System.out.println("Input Airport\nID, name, runway, maxfw, maxrw");
        String[] tokens = Input.getInstance().getLine().split(",");
        while(CheckServices.getInstance().checkID(tokens[0].trim()) != 1){
            System.out.println("Incorrect id. Input again(AP)");
            tokens[0] = Input.getInstance().getLine();
        }
        try {
            return new Airport(tokens[0].trim(), tokens[1].trim(), Double.parseDouble(tokens[2].trim()), Double.parseDouble(tokens[3].trim()), Double.parseDouble(tokens[4].trim()));
        } catch (NumberFormatException e){
            System.out.println("Must input number\nInput again");
            return this.create();
        } catch (ArrayIndexOutOfBoundsException e1){
            System.out.println("Not enought parameter");
            return this.create();
        }
    }
    
    public void addPlane(Airport airport, Airplane p){
        if (p instanceof Helicopter)
            airport.getRwID().add(p);
        else 
            airport.getFwID().add(p);
    }
    
    public boolean canAdd(Airport airport, Airplane p){
        if (p instanceof Helicopter)
            return ((airport.getMaxrw() - airport.getRwID().size()) > 0)? true:false;
        else if (p instanceof FixedWing) {
            FixedWing fw = (FixedWing) p;
            return ((airport.getMaxfw() - airport.getFwID().size()) > 0 && airport.getRunway() > fw.getMinRunWay())? true:false;
        } else return false;
    }
}
