package Battleship;

import java.util.ArrayList;

public class Submarine extends Ship{
    //vars
    String shipName;
    int shipLength;

    // constructor
    Submarine (String name, int length, String[] startCordenates,
                            String direction, String[] shipCoordinates, 
                            ArrayList<String> tilesDamaged){
        
        this.shipName = name;
        this.shipLength = 3;
        this.startCordenates = new String[1];
        this.direction = "";
        this.shipCoordinates = new String[shipLength];
        this.tilesDamaged = new ArrayList<>();
        this.isSunk = false;
    }
    
    
}
