/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment5.services;

import assignment5.io.Input;
import assignment5.models.FixedWing;
import assignment5.models.PlaneType;

/**
 * 
 * @date Jul 1, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class FixedWingServices {
    private static FixedWingServices instance;

    private FixedWingServices() {
    }
    
    public static FixedWingServices getInstance(){
        instance = new FixedWingServices();
        return instance;
    }
    
    public FixedWing create(){
        System.out.println("Input FixedWing plane:\nID, model, cruiseSpeed, emptyWeight, maxTakeOffWeigth, type, minrunway");
        String[] tokens = Input.getInstance().getLine().split(",");
        if (tokens.length == 7){
            while(CheckServices.getInstance().checkID(tokens[0].trim()) != 2){
                System.out.println("Incorrect id. Input ID again(FW)");
                tokens[0] = Input.getInstance().getLine();
            }
            while (!CheckServices.getInstance().checkModel(tokens[1].trim())){
                System.out.println("Model is so long!");
                tokens[1] = Input.getInstance().getLine();
            }
            while (true){
                switch (tokens[5].toLowerCase()){
                    case "cargo": 
                        return new FixedWing(PlaneType.CAG, Double.parseDouble(tokens[6].trim()), tokens[0].trim(), tokens[1].trim(), Double.parseDouble(tokens[2].trim()), Double.parseDouble(tokens[3].trim()), Double.parseDouble(tokens[4].trim()));
                    case "long range":
                        return new FixedWing(PlaneType.LGR, Double.parseDouble(tokens[6].trim()), tokens[0].trim(), tokens[1].trim(), Double.parseDouble(tokens[2].trim()), Double.parseDouble(tokens[3].trim()), Double.parseDouble(tokens[4].trim()));
                    case "private":
                        return new FixedWing(PlaneType.PRV, Double.parseDouble(tokens[6].trim()), tokens[0].trim(), tokens[1].trim(), Double.parseDouble(tokens[2].trim()), Double.parseDouble(tokens[3].trim()), Double.parseDouble(tokens[4].trim()));
                    default:
                        System.out.println("Incorrect type\nInput type again(Cargo | Long range | Private):");
                        tokens[5] = Input.getInstance().getLine();
                }

            } 
        }else {
            System.out.println("Incorrect form");
            return create();
        }
    }
}
