/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment4.service;

import assignment4.model.Operator;
import java.lang.ArithmeticException;

/**
 * 
 * @date Jun 26, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class NormalCalculatorService {
    private static final NormalCalculatorService instance = new NormalCalculatorService();
    
    public static NormalCalculatorService getInstance(){
        return NormalCalculatorService.instance;
    }

    private NormalCalculatorService() {
    }
    
    public double calculate(double number1, Operator ope, double number2){
        switch(ope){
            case INCREASE:
                return (number1 + number2);
            case DECREASE:
                return (number1 - number2);
            case MUTIL:
                return (number1 * number2);
            case DIVIDE:
                if (number2 == 0) throw new ArithmeticException();
                else return (number1 / number2);
            case POW:
                return Math.pow(number1, number2);
        }
        return 0;
    }
}
