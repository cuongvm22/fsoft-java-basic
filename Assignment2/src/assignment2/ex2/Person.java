/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment2.ex2;

import java.util.Scanner;

/**
 * 
 * @date Jun 19, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class Person {
    private Wallet wall;
    private int total;

    public Person(int money) {
        this.total = 0;
        this.wall = new Wallet(money);
    }
    
    public int calcTotal(int[] bills){
        for (int el : bills)
            this.total += el;
        return this.total;
    }

    public Wallet getWall() {
        return wall;
    }

    public int getTotal() {
        return total;
    }
    
    
    
    public class Wallet{
        private int wall;

        public Wallet(int wall) {
            this.wall = wall;
        }
        
        public boolean payMoney(int total){
            if (this.wall >= total) return true;
            else return false;
        }
    }
}
