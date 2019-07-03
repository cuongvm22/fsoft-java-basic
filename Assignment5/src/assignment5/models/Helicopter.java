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
public class Helicopter extends Airplane{
    
    private double range;

    public Helicopter(double range, String ID, String model, double cruiseSpeed, double emptyWeight, double maxTakeOffWeight) {
        super(ID, model, cruiseSpeed, emptyWeight, maxTakeOffWeight);
        this.range = range;
    }

    public Helicopter() {
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }
    
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
         return String.format("{ID: %s, model: %s, cruiseSpeed: %f, emptyWeight: %f, maxTakeOffWeight: %f, range: %f}", 
                this.getID(), this.getModel(),this.getCruiseSpeed(), this.getEmptyWeight(),this.getMaxTakeOffWeight(), this.getRange()
        );
    }

    @Override
    public int compareTo(Airplane t) {
        return this.getID().compareTo(t.getID());
    }
    
}
