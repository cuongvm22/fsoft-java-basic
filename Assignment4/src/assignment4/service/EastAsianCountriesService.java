/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment4.service;

import assignment4.model.EastAsiaCountries;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @date Jun 24, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class EastAsianCountriesService {
    
    private static final EastAsianCountriesService instance = new EastAsianCountriesService();
    
    public static EastAsianCountriesService getInstance(){
        return EastAsianCountriesService.instance;
    }

    private EastAsianCountriesService() {
    }
    
    
    
    public List findByName(List<EastAsiaCountries> countries, String findName){
        List result = new ArrayList();
        for (EastAsiaCountries e : countries)
            if (e.getCountryName().contains(findName))
                result.add(e);
        return result;
    }
}
