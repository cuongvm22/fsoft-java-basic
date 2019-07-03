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
public class Triangle extends Shape{
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() {
        System.out.println("Please input side A of Triangle:");
        this.sideA = s.nextDouble();
        System.out.println("Please input side B of Triangle:");
        this.sideB = s.nextDouble();
        System.out.println("Please input side C of Triangle:");
        this.sideC = s.nextDouble();
    }

    
    
    @Override
    public double getArea() {
        double p = this.getPerimeter() / 2.0;
        return Math.sqrt(p * (p-this.getSideA()) * (p-this.getSideB()) * (p-this.sideC));
    }
    @Override
    public double getPerimeter() {
        return this.sideA + this.getSideB() + this.getSideC();
    }

    @Override
    public void printResult() {
        System.out.printf("-----%s-----\nSideA: %f\nSideB: %f\nSideC: %f\nArea: %f\nPerimeter: %f\n",this.getClass(), this.getSideA(), this.getSideB(), this.getSideC(), this.getArea(), this.getPerimeter());

    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }
    
   
}
