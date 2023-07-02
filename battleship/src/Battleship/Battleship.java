package Battleship;

import java.util.ArrayList;

public class Battleship extends Ship{
    //vars
    String shipName;
    int shipLength;

    // constructor
    Battleship (String name, int length, String[] startCordenates,
                            String direction, String[] shipCoordinates, 
                            ArrayList<String> tilesDamaged){
        
        this.shipName = name;
        this.shipLength = 4;
        this.startCordenates = new String[1];
        this.direction = "";
        this.shipCoordinates = new String[shipLength];
        this.tilesDamaged = new ArrayList<>();
        this.isSunk = false;
    }
    
}
