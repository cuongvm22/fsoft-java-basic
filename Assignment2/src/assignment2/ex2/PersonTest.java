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
public class PersonTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("======= Shopping program ==========");
        int[] bills;
        System.out.print("input number of bill: ");
        bills = new int[s.nextInt()];
        for (int i = 0; i < bills.length; i++){
            System.out.printf("input value of bill %d: ", i+1);
            bills[i] = s.nextInt();
        }
        System.out.print("input value of wallet: ");
        int wall = (s.nextInt());
        Person pe = new Person(wall);
        int total =  pe.calcTotal(bills);
        
        System.out.println("===================================");
        System.out.println("this total of bill: " + total);
        if (pe.getWall().payMoney(total)) System.out.println("You can buy it");
        else System.out.println("You can't buy it");
    }
}
