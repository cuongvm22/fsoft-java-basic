/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment5.models;

/**
 * 
 * @date Jul 1, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public abstract class Airplane implements Comparable<Airplane>{
    private String ID;
    private String model;
    private double cruiseSpeed;
    private double emptyWeight;
    private double maxTakeOffWeight;
    
    public abstract void fly();

    public Airplane(String ID, String model, double cruiseSpeed, double emptyWeight, double maxTakeOffWeight) {
        this.ID = ID;
        this.model = model;
        this.cruiseSpeed = cruiseSpeed;
        this.emptyWeight = emptyWeight;
        this.maxTakeOffWeight = maxTakeOffWeight;
    }

    public Airplane() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(double cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    public double getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(double emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public double getMaxTakeOffWeight() {
        return maxTakeOffWeight;
    }

    public void setMaxTakeOffWeight(double maxTakeOffWeight) {
        this.maxTakeOffWeight = maxTakeOffWeight;
    }

    public abstract String toString();
    
}
