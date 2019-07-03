/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment5.services;

import assignment5.io.Input;
import assignment5.models.Airplane;
import assignment5.models.Airport;
import assignment5.models.FixedWing;
import assignment5.models.Helicopter;
import java.util.Collections;
import java.util.List;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

/**
 * 
 * @date Jul 1, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class MenuServices {
    private static MenuServices instance;
    
    public static MenuServices getInstance(){
        instance = new MenuServices();
        return instance;
    }
    
    public void getStartMenu(List airports){
        int option = 19;
        do{
        System.out.println("======Programp======\n"
                + "1.Input\n"
                + "2.Airport manager\n"
                + "3.Fixed wing airplane management\n"
                + "4.Helicopter management group\n"
                + "0.Exit");
        try{
            option = Integer.parseInt(Input.getInstance().getLine());
            if (option < 0 || option > 4) throw new NumberFormatException();
        } catch (NumberFormatException e){
            System.out.println("Dont have this option!");
            getStartMenu(airports);
        }
        switch (option){
                case 1:
                    getInput(airports);
                    break;
                case 2:
                    airportManager(airports);
                    break;
                case 3:
                    System.out.println(fixedManager(airports));
                    break;
                case 4:
                    System.out.println(helicopterManager(airports));
                    break;
            }
        } while (option != 0);
    }
    
    private void getInput(List airports){
        int option = 10;
        do {
            System.out.println("======Input======\n"
                + "1.Add Airport\n"
                + "2.Add a helicopter to a Airport\n"
                + "3.Add a fixed wing airplane to a Airport\n"
                + "0.Back");
            option = Integer.parseInt(Input.getInstance().getLine());
            switch (option){
                case 1:
                    airports.add(AirportServices.getInstance().create());
                    break;
                case 2:
                    Airplane a = HelicopterServices.getInstance().create();
                    addWithOption(airports, a);
                    break;
                case 3:
                    a = FixedWingServices.getInstance().create();
                    addWithOption(airports, a);
                    break;
            }
        } while (option != 0);
    }
    
    public void addWithOption(List airports, Airplane a){
        int option = -1;
        StringBuilder sb = new StringBuilder("Select your Airport:\ninput -1 to Exit");
        for (int i = 0; i < airports.size(); i++){
            if (AirportServices.getInstance().canAdd((Airport) airports.get(i), a)){
                sb.append("\n");
                sb.append(i);
                sb.append(".");
                sb.append(airports.get(i).toString());
            }
        }
        System.out.println(sb.toString());
        
        do {
            try {
                option = Integer.parseInt(Input.getInstance().getLine());
                if (option < -1 || option > airports.size()) throw new ValueException("");
            } catch (NumberFormatException e){
                System.out.println(option + " is not a number. Select again");
            } catch (ValueException e1){
                System.out.println("Dont have this option. Select again");
            }
        } while (option > airports.size() || option < -1);
        
        if (option == -1)
            return;
        if (AirportServices.getInstance().canAdd((Airport) airports.get(option), a))
            AirportServices.getInstance().addPlane((Airport) airports.get(option), a);
        else
            System.out.println("Cant add it to this airport");
    }

    private void airportManager(List airports){
        int option = 10;
        do {
            System.out.println("======Input======\n"
                + "1.Display list of all airport information, sorted by airport ID\n"
                + "2.Display the status of one airport, selected by airport ID\n"
                + "0.Back");
            try {
                option = Integer.parseInt(Input.getInstance().getLine());
                if (option < 0 || option > 2) throw new NumberFormatException();
            } catch (NumberFormatException e){
                System.out.println("Dont have this option");
                airportManager(airports);
            }
            switch (option){
                case 1:
                    System.out.println(getSorted(airports));
                    break;
                case 2:
                    System.out.println(getImforById(airports));
                    break;
            }
        } while (option != 0);
    }
    
    private String getImforById(List<Airport> airports){
        StringBuilder sb = new StringBuilder();
        String id = "";
        System.out.print("Input Airport ID:");
        while(CheckServices.getInstance().checkID((id = Input.getInstance().getLine())) != 1);
        for (Airport e : airports)
            if (e.getID().equals(id))
                sb.append(e.toString() + "\n");
        return sb.toString();
    }
    
    private String getSorted(List<Airport> airports){
        Collections.sort(airports, (Airport o1, Airport o2) -> {
            return o1.getID().compareTo(o2.getID());
        });
        
        StringBuilder sb = new StringBuilder();
        for (Airport e : airports){
            sb.append(e.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    
    private String fixedManager(List<Airport> airports){
        StringBuilder sb = new StringBuilder();
        airports.forEach((air) -> {
            ((List<FixedWing>) air.getFwID()).forEach((fw) -> {
                sb.append(fw.toString() + " -> " +air.getID() + " | " + air.getName() + "\n");
            });
        });
        return sb.toString();
    }
    
    private String helicopterManager(List<Airport> airports){
        StringBuilder sb = new StringBuilder();
        airports.forEach((air) -> {
            ((List<Helicopter>) air.getRwID()).forEach((rw) -> {
                sb.append(rw.toString() + air.getID() + air.getName() + "\n");
            });
        });
        return sb.toString();
    }
}
