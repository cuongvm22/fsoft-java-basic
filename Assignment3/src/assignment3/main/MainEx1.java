/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment3.main;

import assignment3.IO.IO;
import assignment3.ex1.Check;

/**
 * 
 * @date Jun 21, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class MainEx1 {
    public static void main(String[] args) {
        IO io = new IO();
        Check c = new Check();
        String a = "";
        do {
            System.out.println(a);
            a = io.getPhone();
            a = c.checkPhone(a);
        } while (a != null);
        a = "";
        do {
            System.out.println(a);
            a = io.getMail();
            a = c.checkMail(a);
        } while (a != null);
        a = "";
        do {
            System.out.println(a);
            a = io.getDate();
            a = c.checkDate(a);
            
        } while (a != null);
    }
}
