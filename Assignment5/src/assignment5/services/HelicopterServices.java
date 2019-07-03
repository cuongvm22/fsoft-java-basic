/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment5.services;

import assignment5.io.Input;
import assignment5.models.Helicopter;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

/**
 * 
 * @date Jul 1, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class HelicopterServices {
    private static HelicopterServices instance;

    private HelicopterServices() {
    }
    
    public static HelicopterServices getInstance(){
        instance = new HelicopterServices();
        return instance;
    }
    
    public Helicopter create(){
        Helicopter result = new Helicopter();
        System.out.println("Input Helicopter plane:\nID, model, cruiseSpeed, emptyWeight, maxTakeOffWeigth, range");
        String[] tokens = Input.getInstance().getLine().split(",");
        if (tokens.length == 6){
            while(CheckServices.getInstance().checkID(tokens[0].trim()) != 3){
                System.out.println("Incorrect id. Input ID again(RW)");
                tokens[0] = Input.getInstance().getLine();
            }
            while (!CheckServices.getInstance().checkModel(tokens[1].trim())){
                System.out.println("Model is so long!");
                tokens[1] = Input.getInstance().getLine();
            }
            while (true){
                try{
                    result = new Helicopter(Double.parseDouble(tokens[5].trim()), tokens[0].trim(), tokens[1].trim(), Double.parseDouble(tokens[2].trim()), Double.parseDouble(tokens[3].trim()), Double.parseDouble(tokens[4].trim()));
                    if (!CheckServices.getInstance().checkValue(result.getMaxTakeOffWeight(), result.getEmptyWeight()))
                        throw new ValueException("");
                    break;
                } catch (NumberFormatException e){
                    System.out.println("Must input number\nInput - cruiseSpeed, emtyWeight, maxTakeOffWeight, range:");
                    String[] a = Input.getInstance().getLine().trim().split(",");
                    tokens[2] = a[0];
                    tokens[5] = a[3];
                } catch (ValueException e1){
                    System.out.println("Takeoff weigth < 1.5 empty weight\nInput - emptyWeight, maxTakeOffWeigth:");
                    String[] a = Input.getInstance().getLine().trim().split(",");
                    tokens[3] = a[0];
                    tokens[4] = a[1];
                }
            }
            return result;        
        }else {
            System.out.println("Incorrect form");
            return create();
        }
    }
}
