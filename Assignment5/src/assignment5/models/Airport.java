/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment5.models;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @date Jul 1, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class Airport {
    private String ID;
    private String name;
    private double runway;
    private double maxfw;
    private List fwID;
    private double maxrw;
    private List rwID;

    public Airport() {
        this("","",0.0,0.0,0.0);
    }

    public Airport(String ID, String name, double runway, double maxfw, double maxrw) {
       this(ID, name, runway, maxfw, new ArrayList(), maxrw, new ArrayList());
    }

    public Airport(String ID, String name, double runway, double maxfw, List fwID, double maxrw, List rwID) {
        this.ID = ID;
        this.name = name;
        this.runway = runway;
        this.maxfw = maxfw;
        this.fwID = fwID;
        this.maxrw = maxrw;
        this.rwID = rwID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRunway() {
        return runway;
    }

    public void setRunway(double runway) {
        this.runway = runway;
    }

    public double getMaxfw() {
        return maxfw;
    }

    public void setMaxfw(double maxfw) {
        this.maxfw = maxfw;
    }

    public List getFwID() {
        return fwID;
    }

    public void setFwID(List fwID) {
        this.fwID = fwID;
    }

    public double getMaxrw() {
        return maxrw;
    }

    public void setMaxrw(double maxrw) {
        this.maxrw = maxrw;
    }

    public List getRwID() {
        return rwID;
    }

    public void setRwID(List rwID) {
        this.rwID = rwID;
    }

    @Override
    public String toString() {
        return "Airport{" + "ID=" + ID + ", name=" + name + ", runway=" + runway + ", maxfw=" + maxfw + ", fwID=" + fwID + ", maxrw=" + maxrw + ", rwID=" + rwID + '}';
    }
    
    
    
}
