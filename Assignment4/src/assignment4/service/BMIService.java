/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment4.service;

import assignment4.model.BMI;

/**
 * 
 * @date Jun 26, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class BMIService {
    private static final BMIService instance = new BMIService();
    
    public static BMIService getInstance(){
        return BMIService.instance;
    }

    private BMIService() {
    }
    
    public BMI calculateBMI(double weight, double height){
        height /= 100;
        double bmi = weight / Math.pow(height, 2);
        System.out.println("BMI Status: " + bmi);
        if (bmi < 19)
            return BMI.BELOW;
        else if (bmi < 25)
            return BMI.STANDARD;
        else if (bmi < 30)
            return BMI.OVER;
        else if (bmi < 40)
            return BMI.FAT;
        else 
            return BMI.VERYFAT;
    }
}
