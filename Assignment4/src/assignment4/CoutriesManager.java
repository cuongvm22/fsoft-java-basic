/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment4;

import assignment4.io.Input;
import assignment4.model.EastAsiaCountries;
import assignment4.service.EastAsianCountriesService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @date Jun 24, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class CoutriesManager {
    public static void main(String[] args) {
        List<EastAsiaCountries> a = new ArrayList();
        Boolean check = true;
        while (check){
            int n = Input.getInstance().getOptionEx2();
            switch (n){
                    case 1:
                        Input.getInstance().inputCountry(a);
                        break;
                    case 2: 
                        for (EastAsiaCountries e : a)
                            e.display();
                        break;
                    case 3: 
                        List<EastAsiaCountries> b = EastAsianCountriesService.getInstance().findByName(a, Input.getInstance().getName());
                        for(EastAsiaCountries e : b)
                            e.display();
                        break;
                    case 4:
                        Collections.sort(a);
                        for (EastAsiaCountries e : a)
                            e.display();
                        break;
                    case 5:
                        check = false;
                        break;
            }
        }
    }
}
