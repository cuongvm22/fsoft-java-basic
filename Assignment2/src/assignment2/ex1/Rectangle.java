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
public class Rectangle extends Shape{
    private double height;
    private double width;

    public Rectangle() {
        System.out.println("Please input side width of Rectangle:");
        this.width = s.nextDouble();
        System.out.println("Please input length of Rectangle:");
        this.height = s.nextDouble();

    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return (this.height + this.width) * 2;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    
    @Override
    public void printResult() {
        System.out.printf("-----%s-----\nWidth: %f\nHeight: %f\nArea: %f\nPerimeter: %f\n", this.getClass().toString(),this.getWidth(), this.getHeight(), this.getArea(), this.getPerimeter());
    }
    

  
    
}
