/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.ex1;

import java.util.Scanner;

/**
 *
 * @author cuongvm
 */
public abstract class Shape {
    static Scanner s = new Scanner(System.in);
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void printResult();
}
