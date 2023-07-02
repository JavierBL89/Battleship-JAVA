package Battleship;
import java.util.*;

public class Ship {
    //vars 
    String[] startCordenates;
    String direction;
    String[] shipCoordinates;
    ArrayList<String> tilesDamaged;
    boolean isSunk;
    int shipLength;

    // constructor
    Ship (){
        startCordenates = new String[1];
        direction = "";
        shipCoordinates = new String[shipLength];
        tilesDamaged = new ArrayList<>();
        isSunk = false;
    }
    
}

