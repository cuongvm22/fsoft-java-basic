/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment4.io;

import assignment4.model.EastAsiaCountries;
import assignment4.model.Operator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @date Jun 24, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class Input {
    private static final Scanner s = new Scanner(System.in);
    private static final Input instance = new Input();
    
    public static Input getInstance(){
        return Input.instance;
    }
    
    public void inputCountry(List countries){
        EastAsiaCountries a = null;
        for (int i = 0; i < 11; i++){
            a = new EastAsiaCountries();
            System.out.println("Enter code of country:");
            a.setCountryCode(s.nextLine().trim());
            System.out.println("Enter name of country:");
            a.setCountryName(s.nextLine().trim());
            System.out.println("Enter total Area:");
            a.setTotalArea(Integer.parseInt(s.nextLine().trim()));
            System.out.println("Enter terrain of country:");
            a.setCountryTerrain(s.nextLine().trim());
            countries.add(a);
        }
    }
    
    public int getOptionEx2(){
        System.out.println("==========================================================================\n" +
                            "1. Input the information of 11 countries in East Asia\n" +
                            "2. Display the information of country you've just input\n" +
                            "3. Search the information of country by user-entered name\n" +
                            "4. Display the information of countries sorted name in ascending order\n" +
                            "5. Exit\n" +
                            "==========================================================================\n"
                                            + "Enter your choice :");
        try {
            return Integer.parseInt(s.nextLine().trim());
        } catch (Exception e){
            return getOptionEx2();
        }
    }
    
    public String getName(){
        return s.nextLine();
    }
    
    public double getNumber(){
        System.out.print("Enter number: ");
        try {
            return Double.parseDouble(s.nextLine());
        } catch (Exception e){
            System.out.println("Please input number!");
            return getNumber();
        }
    }
    
    public Operator getOperator(){
        System.out.print("Enter Operator: ");
        switch(s.nextLine().trim()){
            case "+": 
                return Operator.INCREASE; 
            case "-":
                return Operator.DECREASE;
            case "*":
                return Operator.MUTIL;
            case "/":
                return Operator.DIVIDE;
            case "^":
                return Operator.POW;
            case "=":
                return Operator.EQUAL;
            default:
                System.out.println("Please input (+, -, *, /, ^)");
                return getOperator();
        }
    }
    public int getOptionEx1(){
        System.out.print("========= Calculator Program =========\n" +
                        "1. Normal Calculator\n" +
                        "2. BMI Calculator\n" +
                        "3. Exit\n" +
                        "Please choice one option: ");
        try {
            int opt = Integer.parseInt(s.nextLine());
            if (opt < 1 || opt > 3) throw new Exception();
            return opt;
        } catch (Exception e){
            System.out.println("Input 1 - 2 - 3");
            return getOptionEx1();
        }
    }
    public double getWeight(){
        System.out.print("Enter Weight(kg): ");
        double weight;
        try {
            weight = Double.parseDouble(s.nextLine());
            if (weight <= 0) throw new Exception("Must > 0");
            else return weight;
        } catch (Exception e){
            if (e instanceof NumberFormatException)
                System.out.println("Must be a number!");
            else 
                System.out.println("Must must postive number");
            
            return getWeight();
                 
        }
    }
    public double getHeight(){
        System.out.print("Enter Height(cm): ");
        double weight;
        try {
            weight = Double.parseDouble(s.nextLine());
            if (weight <= 0) throw new Exception("Must > 0");
            else return weight;
        } catch (Exception e){
            if (e instanceof NumberFormatException)
                System.out.println("Must be a number!");
            else 
                System.out.println("Must must postive number");
            
            return getWeight();
                 
        }
    }
}
