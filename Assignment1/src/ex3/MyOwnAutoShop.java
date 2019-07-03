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
public class MyOwnAutoShop {
    public static void main(String[] args) {
        Car sedan1 = new Sedan(30, 50, 1000, "white");
        Car ford1 = new Ford(1997, 10, 100, 20000, "Black");
        Car ford2 = new Ford(1990, 5, 150, 2500, "Red");
        Car car1 = new Car(98, 900, "Blue");
        Car car2 = new Car(98, 950, "Yellow");
        
        System.out.println(sedan1.getSalePrice());
        System.out.println(ford1.getSalePrice());
        System.out.println(ford2.getSalePrice());
        System.out.println(car1.getSalePrice());
        System.out.println(car2.getSalePrice());
    }
}
