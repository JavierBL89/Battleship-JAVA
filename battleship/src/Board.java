import javax.swing.JPanel;
import java.awt.*;
import java.util.Arrays;

public class Board extends JPanel {
    //vars
    int BOARD_WIDTH;
    int BOARD_HEIGHT;
    int x;
    int y;
    String grid [][];
    String playerName;
    Integer gameGrid [][];
    int UNIT_SIZE;

    //constructor
    Board(String playerName){
        UNIT_SIZE = 20;
        BOARD_WIDTH = 200;
        BOARD_HEIGHT = 200;
        grid = new String[10][10];
        gameGrid = new Integer[10][10];
        this.playerName = playerName;
        this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        //this.setBackground(Color.black);
        
    };

    /**
    * Method helped me to build the game with a grid printed on the cosole
     */
    public String[][] newBoard(){
        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid.length;j++){
                if(grid[i][j] == grid[0][0]){
                    grid[i][j] = " ";
                }
                else if(grid[i][j] == grid[i][0]){
                    grid[i][j] = Integer.toString(i);
                }else if(grid[i][j] == grid[0][j] ){
                    grid[i][j] = Integer.toString(j);
                }else{
                    grid[i][j] = "0";
                }
                System.out.print(grid[i][j]) ; 
                System.out.print(" ") ; 
            }
            System.out.println(" ") ; 
        }
     return grid;
    };

    
    public void paintComponent(Graphics g){
        // This method will apply to the panel the settings we set before Color, size, fonts..
        super.paintComponent(g);
        draw(g);
    }

    /**
     * 
     * This method takes care of drawing everything on the panel
     */
    public void draw(Graphics g){

        Graphics panelGrid = g.create();
        // Grab the player ships arrays from the Battleship class to draw them
        String[] compuShips = Battleship.compuShips;
        String[] playerShips = Battleship.playerShips;
        
        // Draws a grid for both boards(panels)
        for(int i = 0; i < gameGrid.length;i++){
            panelGrid.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, BOARD_HEIGHT );
            panelGrid.drawLine(0, i*UNIT_SIZE, BOARD_WIDTH , i*UNIT_SIZE);               
        }
        
        // Draw player's boards with their ships
        if(this.playerName == "Compu"){
            for(int i=0;i< compuShips.length ;i++){
                for(int j=0;j< compuShips[i].length();j++){
                    x =  Character.getNumericValue(compuShips[i].charAt(1));
                    y =  Character.getNumericValue(compuShips[i].charAt(4));
                   // System.out.println(x + " " + y);

                   panelGrid.setColor(Color.black);        
                   panelGrid.fillRect(y*UNIT_SIZE,x*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
              
               }
            }
        }else if(this.playerName == "Player"){
                for(int i=0;i< playerShips.length ;i++){
                    for(int j=0;j< playerShips[i].length();j++){
                        x =  Character.getNumericValue(playerShips[i].charAt(1));
                        y =  Character.getNumericValue(playerShips[i].charAt(4));
                       // System.out.println(x + " " + y);
    
                        panelGrid.setColor(Color.black);        
                        panelGrid.fillRect(y*UNIT_SIZE,x*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
                   }
                }
    }
  

    }

   /**
    * Method helped me to build the game with a grid printed on the cosole
    */
    public void updateBoardTest(String player, int x, int y){
        if(player == "puta"){
            for(int i=0;i< grid.length;i++){
                for(int j=0;j< grid.length;j++){
                       grid[i][j] =  Integer.toString(j);
                    if(grid[i][j] == grid[x][y]) {        
                        grid[i][j] = "W";
                    }else if(grid[i][j] == grid[0][0]){
                        grid[i][j] = " ";
                    }
                    else if(grid[i][j] == grid[i][0]){
                        grid[i][j] = Integer.toString(i);
                    }else if(grid[i][j] == grid[0][j] ){
                        grid[i][j] = Integer.toString(j);
                    }else{
                        grid[i][j] = "-";
                    }
                    System.out.print(grid[i][j]) ; 
                    System.out.print(" ") ; 
                //}
                    
                }
                System.out.println(" ") ; 
                 
           }
   }

    }
}
