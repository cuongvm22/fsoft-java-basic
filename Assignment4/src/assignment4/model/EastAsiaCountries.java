/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment4.model;

/**
 * 
 * @date Jun 24, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class EastAsiaCountries extends Country implements Comparable<EastAsiaCountries>{
    private String countryTerrain;

    @Override
    public String toString() {
        return super.toString() + "EastAsiaCountries{" + "countryTerrain=" + countryTerrain + '}';
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        System.out.println(this.toString());
    }

    public EastAsiaCountries(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public EastAsiaCountries() {
    }

    @Override
    public int compareTo(EastAsiaCountries o) {
       return this.getCountryName().compareTo(o.getCountryName());
    }
    
}
