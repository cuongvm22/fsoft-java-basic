/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment3.ex1;

import java.text.SimpleDateFormat;

/**
 * 
 * @date Jun 21, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class Check {
    public  String checkPhone(String phone){
        if (phone.matches("^0[0-9]+"))
            if (phone.matches("[0-9]{10}"))
                return null;
            else return "Number must is 10 digits";
        else 
            return "Phone number must is number ";
    }
    public  String checkMail(String mail){
        if (mail.matches("\\w+@\\w+\\.\\w{2,4}\\.{0,1}\\w{0,4}"))
            return null;
        else 
            return "Email is incorrect";
    }
    
    public  String checkDate(String date){
        try{
            (new SimpleDateFormat("dd/MM/yyyy")).parse(date);
            return null;
        } catch(Exception e){
            return "Date is incorrect format";
        }
    }
    
    
}
