/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment3.IO;

import assignment3.ex1.Check;
import assignment3.ex2.model.Department;
import assignment3.ex2.model.HourlyEmployee;
import assignment3.ex2.model.SalariedEmployee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @date Jun 21, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class IO{
    private static Scanner s;
    public IO() {
//         s = new Scanner(new File("data.txt"));
           s = new Scanner(System.in);
    }
    
    public  String getPhone(){
        System.out.print("Phone number: ");
        return s.nextLine();
    }
    public  String getMail(){
        System.out.print("Email: ");
        return s.nextLine();
    }
    public  String getDate(){
        System.out.print("Date (dd/MM/YYYY): ");
        return s.nextLine();
    }
    
    public void getEmployee(Department de){
        Check c = new Check();
        System.out.println("Input employees of "+ de.getDepartmentName());
        System.out.println("Input correct form: "
                + "\nssn(*),firstName(*),lastName(*), birthDate, phone, email, wage(*), workingHours(*)"
                + "\nssn(*),firstName(*),lastName(*), birthDate, phone, email, commissionRate(*), grossSales(*), basicSalary(*)"
                + "\nInput incorrect form to exit");
        String[] tokens;
        // if tokens == 5 || 8 - add a HourlyEmployee
        // if tokens == 6 || 9 - add a SalariedEmployee
        while (true){
            tokens = this.s.nextLine().split(",");
            if (tokens.length == 5 ){
                de.addEmployee(new HourlyEmployee(Double.parseDouble(tokens[3].trim()), Double.parseDouble(tokens[4]), tokens[0].trim(), tokens[1].trim(), tokens[2].trim()));
                System.out.println("Add done!");
            } else if (tokens.length == 8){
                while (c.checkDate(tokens[3].trim()) != null) tokens[3] = this.getDate();
                while (c.checkPhone(tokens[4].trim()) != null) tokens[4] = this.getPhone();
                while (c.checkMail(tokens[5].trim()) != null) tokens[5] = this.getMail();
                de.addEmployee(new HourlyEmployee(Double.parseDouble(tokens[6].trim()), Double.parseDouble(tokens[7].trim()), tokens[0].trim(), tokens[1].trim(), tokens[2].trim(), tokens[3], tokens[4], tokens[5]));
                System.out.println("Add done!");
            } else if (tokens.length == 6){
                de.addEmployee(new SalariedEmployee(Double.parseDouble(tokens[3].trim()), Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]) ,tokens[0].trim(), tokens[1].trim(), tokens[2].trim()));
                System.out.println("Add done!");
            }else if (tokens.length == 9){
                while (c.checkDate(tokens[3].trim()) != null) tokens[3] = this.getDate();
                while (c.checkPhone(tokens[4].trim()) != null) tokens[4] = this.getPhone();
                while (c.checkMail(tokens[5].trim()) != null) tokens[5] = this.getMail();
                de.addEmployee(new SalariedEmployee(Double.parseDouble(tokens[6].trim()), Double.parseDouble(tokens[7].trim()), Double.parseDouble(tokens[8].trim()), tokens[0].trim(), tokens[1].trim(), tokens[2].trim(), tokens[3], tokens[4], tokens[5]));
                System.out.println("Add done!");
            } else break;
        }
    }
    
    public List getDepartment(){
        List result = new ArrayList();
        String s = "";
        String[] tokens = null;
        System.out.println("Input departments\nInput 0 to exit\n");
        while (true){
            s = this.s.nextLine();
            if (s.equals("0")) break;
            result.add(new Department(s));
        }
        return result;
    }
    
    public String getLine(){
        return s.nextLine();
    }
}
