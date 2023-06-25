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
            List<String> ocupateTiles = new ArrayList<>();

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
                // add x & y to create the radomShip...
                //.... and push the start ships coordenate into the ships array
                startCordenates[0] = x;
                startCordenates[1] = y;
                tempShip[0] = Arrays.toString(startCordenates);
                // Create the next cell ship coordenatate..
                // ..and push it into the tempShip array to continue ship 
                if(randomDirection == "down"){
                    nextTile[0] = Integer.parseInt(x) + 1;
                    nextTile[1] = Integer.parseInt(y) ;
                }else if(randomDirection == "right"){
                    nextTile[0] = Integer.parseInt(x);
                    nextTile[1] = Integer.parseInt(y)+1;
                }
                tempShip[1] = Arrays.toString(nextTile);

                // check if ship tiles are available
                checkCellAvailability(playerName, ships, tempShip, ocupateTiles);

                // If new cells ship are available,.. 
                //..check if they are within the board limits, else generate new ships
                 if((Integer.parseInt(startCordenates[0]) + (shipLength - 1) > 9 || 
                                     (Integer.parseInt(startCordenates[1]) + (shipLength - 1) > 9))){
                    shipGenerator( playerName, ships);
                 }else{
                   ships[i] = tempShip;
                  ocupateTiles.add(tempShip[0]);
                  ocupateTiles.add(tempShip[1]);
                 }

            }

            if(playerName == "Compu"){
                    compuShips = ships;
            }else if(playerName == "Player"){
                    playerShips = ships;
                }

        }

         /***
         * Check used cells, if any of the new ship cells are in used,
         *  call shipGenerator and generate new ships
         *   Otherwise add the new ship cells into ocupateTiles array,...
         *  ...and keep the shipgenerator going the next ship
         */
        public void checkCellAvailability(String playerName, String[][] ships, String[] tempShip,List<String> ocupateTiles){

            if(ocupateTiles.size() == 0){
                    ocupateTiles.add(tempShip[0]);
                    ocupateTiles.add(tempShip[1]);
                }else if(ocupateTiles.size() > 0){
                    for(int h=0;h<ocupateTiles.size();h++){
                       if(ocupateTiles.get(h).contains(tempShip[0])){
                           System.out.println("First ship title matches an occupied title");
                           System.out.println("Generating a new entire ship..");
                           shipGenerator(playerName, ships);
                       }else if(ocupateTiles.get(h).contains(tempShip[1])){ 
                            System.out.println("First ship title matches an occupied title");
                            System.out.println("Generating a new entire ship..");
                           shipGenerator(playerName, ships);
                    }else{
                            continue;
                       }
                    }
                }

        }
}

