/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment5.io;

import java.util.Scanner;

/**
 * 
 * @date Jul 1, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class Input {
    
    private final Scanner s = new Scanner(System.in);
    private final static Input instance = new Input();
    
    public static Input getInstance(){
        return Input.instance;
    }

    private Input() {
    }
    
    public String getLine(){
        return s.nextLine();
    }
    
    public void close(){
        s.close();
    }
    
}
