/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.ex1;

/**
 *
 * @author cuongvm
 */
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("====Calculator Shape Progarmer====");
        Rectangle r = new Rectangle();
        Circle c = new Circle();
        Triangle t = new Triangle();
        
        r.printResult();
        c.printResult();
        t.printResult();
        
    }
    
}
