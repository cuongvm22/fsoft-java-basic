/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ex4;

/**
 * 
 * @date Jun 18, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class NumberTest {
    public static void main(String[] args) {
        InsertSort a = new InsertSort(6);
//        a.input();
        a.print();
        a.sort();
        a.print();
    }
}
