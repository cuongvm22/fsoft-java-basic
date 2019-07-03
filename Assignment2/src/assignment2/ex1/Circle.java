/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment2.ex1;
/**
 * 
 * @date Jun 19, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class Circle extends Shape{

    private double radius;

    public Circle() {
        System.out.println("Please input radius of Circle:");
        this.radius = s.nextDouble();
    }
    
    @Override
    public double getArea() {
       return Math.pow(this.radius, 2) * Math.PI;

    }

    @Override
    public double getPerimeter() {
        return (this.radius * 2) * Math.PI;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void printResult() {
        System.out.printf("-----%s-----\nRadius: %f\nArea: %f\nPerimeter: %f\n",this.getClass(), this.getRadius(), this.getArea(), this.getPerimeter());
    }

}
