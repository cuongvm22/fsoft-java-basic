/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment4;

import assignment4.io.Input;
import assignment4.model.Operator;
import assignment4.service.BMIService;
import assignment4.service.NormalCalculatorService;

/**
 * 
 * @date Jun 26, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class Calculator {
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        
        int option = Input.getInstance().getOptionEx1();
        System.out.println("");
        double result, num2;
        Operator ope = null;
        while (option != 3){
            switch(option){
                case(1):
                    System.out.println("----- Normal Calculator -----");
                    result = Input.getInstance().getNumber();
                    ope = Input.getInstance().getOperator();
                    while (ope != Operator.EQUAL){
                        try{
                            num2 = Input.getInstance().getNumber();
                            result = NormalCalculatorService.getInstance().calculate(result, ope, num2);
                            System.out.println("Memory: " + result);
                            ope = Input.getInstance().getOperator();
                        } catch(ArithmeticException e){
                            System.err.println("Cant divide by Zero!");
                            continue;
                        }
                    }
                    System.out.println("Result: " + result);
                    break;
                case(2):
                    System.out.println("----- BMI Calculator -----");
                    System.out.println("BMI Status: " + BMIService.getInstance().calculateBMI(Input.getInstance().getWeight(), Input.getInstance().getHeight()));
                    break;
            }
            System.out.println("");
            option = Input.getInstance().getOptionEx1();
        }
    }
}
