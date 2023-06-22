import java.awt.font.GraphicAttribute;
import java.util.*;

public class Battleship {
    //vars 
    String[] carrier;
    public static String[][] compuShips;
    public static String[][] playerShips;
    // Array to store the random ship coordenates
    String[] startCordenates = new String[2];
    String[] direction = {"down", "right"};

    List<String> ocupateTiles = new ArrayList();



    String x;
    String y;
    String playerName;
    int shipLength = 2;
    String randomDirection;
    
    // constructor
    Battleship (){
        carrier = new String[1];
        compuShips = new String[3][3];
        playerShips = new String[3][3];
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
     * Generate random ships(1 cell length) and push them into players arrays
     * Check for duplicate ships
     */
    public void shipGenerator(String playerName, String[][] ships){

            // set playerName value
            this.playerName = playerName;
            // loops through ships array(3 ships length), and generate a random ship per each index,...
            //.... and push it into the array
            for(int i=0; i < ships.length ;i++){
                int curr = i;
                int next = i+1;
                int[] nextTile = new int[2];
                String[] tempShip = new String[2];

                // generate a rondom number for x & y 
                Random ran = new Random();
                int n = ran.nextInt(2);
                randomDirection = direction[n];
                x = Integer.toString(ran.nextInt(10));
                y = Integer.toString(ran.nextInt(10));
                // add x & y to create the radomShip and push the ship into the ships array
                startCordenates[0] = x;
                startCordenates[1] = y;
                
                tempShip[0] = Arrays.toString(startCordenates);

                if(randomDirection == "down"){
                    nextTile[0] = Integer.parseInt(x) + 1;
                    nextTile[1] = Integer.parseInt(y) ;
                }else if(randomDirection == "right"){
                    nextTile[0] = Integer.parseInt(x);
                    nextTile[1] = Integer.parseInt(y)+1;
                }

                if((Integer.parseInt(startCordenates[0]) + (shipLength - 1)) > 9){
                      shipGenerator( playerName, ships);
                }else{
                    tempShip[1] = Arrays.toString(nextTile);
                     if(i == 0 ){
                     ships[0] = tempShip;
                      // System.out.println(Arrays.toString(ships[0])  +" i");
                }
                     else if(i == 1 ){
                        ships[1] = tempShip;
                        // System.out.println(Arrays.toString(ships[0])  +" o");
                        // System.out.println(Arrays.toString(ships[1])  +" o");
                    }
                    else if(i == 2 ){
                     ships[2] = tempShip;
                    //System.out.println(Arrays.toString(ships[2])  +" p");

                     }

                }
        //         System.out.println(i + " ITERATION");
        //         System.out.println(Arrays.toString(tempShip) + "TEMPSHIP");
        //         for(int j=0; j < ships.length;j++){
        //                 System.out.println(Arrays.toString(ships[j]) + j + " w");
        //   }

            }
            if(playerName == "Compu"){
                    compuShips = ships;
            }else if(playerName == "Player"){
                    playerShips = ships;
                }

        }


}

