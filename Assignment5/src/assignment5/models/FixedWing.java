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
public class FixedWing extends Airplane{

    private PlaneType type;
    private double minRunWay;

    public FixedWing(PlaneType type, double minRunWay, String ID, String model, double cruiseSpeed, double emptyWeight, double maxTakeOffWeight) {
        super(ID, model, cruiseSpeed, emptyWeight, maxTakeOffWeight);
        this.type = type;
        this.minRunWay = minRunWay;
    }

    public FixedWing() {
    }

    public PlaneType getType() {
        return type;
    }

    public void setType(PlaneType type) {
        this.type = type;
    }

    public double getMinRunWay() {
        return minRunWay;
    }

    public void setMinRunWay(double minRunWay) {
        this.minRunWay = minRunWay;
    }
    
    
    
    @Override
    public void fly() {
        System.out.println("fixed wing");
    }

    @Override
    public String toString() {
        return String.format("{ID: %s, model: %s, cruiseSpeed: %f, emptyWeight: %f, maxTakeOffWeight: %f, type: %s, minRunWay: %f}", 
                this.getID(), this.getModel(),this.getCruiseSpeed(), this.getEmptyWeight(),this.getMaxTakeOffWeight(), this.getType(), this.getMinRunWay()
        );
    }

    @Override
    public int compareTo(Airplane t) {
        return  this.getID().compareTo(t.getID());
    }
    
    
}
