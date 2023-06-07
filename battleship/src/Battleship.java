import java.awt.font.GraphicAttribute;
import java.util.*;

public class Battleship {
    //vars 
    String[] carrier;
    public static String[] compuShips;
    public static String[] playerShips;
    String x;
    String y;
    String playerName;
    int shipLength;
    
    // constructor
    Battleship (){
        carrier = new String[1];
        compuShips = new String[3];
        playerShips = new String[3];
    }
    
    /**
     * Sets player ships array
     */
    public void setPlayerShips(String playerName){
        if(playerName == "Compu"){
            shipGenerator(playerName, compuShips);
        }else if(playerName == "Player"){
            shipGenerator(playerName, playerShips);
        }
    }

    /**
     * Generate random ships and push them into players array
     * Check for duplicate ships
     */
    public void shipGenerator(String playerName, String[] ships){

            // set playerName value
            this.playerName = playerName;

            // Array to store the ship created
            String[] shipCoordenates = new String[2];

            // loops through ships array, and generate a random ship per each index,...
            //.... and push it into the array
            for(int i=0; i < ships.length;i++){
                int curr = i;
                int next = i+1;
                Random ran = new Random();
                x = Integer.toString(ran.nextInt(10));
                y = Integer.toString(ran.nextInt(10));
                // add coordenates to shipCoordenates 
                shipCoordenates[0] = x;
                shipCoordenates[1] = y;
                ships[curr] = Arrays.toString(shipCoordenates);

                //Loop through each ship in the ships array...
                //... and check if the current ship coordenates are the same as the next ship coordenates,..
                //... if so generate a new ship
                for(int j=0;j < ships[curr].length();j++){
                    if(i >=0 && next > ships[curr].length() -1){ 
                    if(ships[curr] == ships[next]){
                        // remove duplicated ship by assigning the index value to null
                        ships[next] = null;
                        shipGenerator(playerName, ships);
                    }
                }
                }
                // Fill the player ships array accordingly
                if(playerName == "Compu"){
                    compuShips = ships;
                }else if(playerName == "Player"){
                    playerShips = ships;

                }
                 //checkShips(x, y);
            }
            System.out.println(Arrays.toString(compuShips));
            System.out.print(" ");
            System.out.println(Arrays.toString(playerShips));
        }


}
