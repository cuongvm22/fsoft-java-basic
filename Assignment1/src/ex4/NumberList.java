/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ex4;

import java.util.Scanner;

/**
 * 
 * @date Jun 18, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class NumberList {
    private int n;
    private int[] array;
    static Scanner s = new Scanner(System.in);

    public NumberList(int n) {
        this.n = n;
        this.input();
    }
    
    public void input(){
        this.array = new int[this.n];
        System.out.println("Input " + this.n + " number:");
        for (int i = 0; i < n; i++)
            this.array[i] = s.nextInt();
    }

    public int[] getArray() {
        return array;
    }
    
    
    public void print(){
        try {
            for (int i : this.array)
                System.out.print(i + "\t");
            System.out.println("");
        } catch (NullPointerException e){
            System.out.println("Array is undentifile. Use input()");
        }
    }
}
