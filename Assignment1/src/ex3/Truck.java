/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ex3;

/**
 * 
 * @date Jun 18, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class Truck extends Car {

    private int weight;
    
    public Truck(int weight, int speed, double regularPrice, String color) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }
    
    @Override
    public double getSalePrice() {
        if (this.weight > 2000) return 90.0/100.0 * this.getRegularPrice();
        else return 80.00/100.0 * this.getRegularPrice();
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    

}
