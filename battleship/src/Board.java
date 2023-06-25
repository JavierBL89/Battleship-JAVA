
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
        String[][] compuShips = Battleship.compuShips;
        String[][] playerShips = Battleship.playerShips;
        
        // Draws a grid for both boards(panels)
        for(int i = 0; i < gameGrid.length;i++){
            panelGrid.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, BOARD_HEIGHT );
            panelGrid.drawLine(0, i*UNIT_SIZE, BOARD_WIDTH , i*UNIT_SIZE);               
        }
        // Draw player's boards with their ships
        if(this.playerName == "Compu"){
// shipsArray [
//              i[ j[ k[] k[] ]  ]
//              i[ j[ k[] k[] ]  ]
//              i[ j[ k[] k[] ]  ]
//             ]
            for(int i=0;i< compuShips.length;i++){
                 for(int j=0;j< compuShips[i].length;j++){
                   for(int k=0;k< compuShips[i].length;k++){
                       x =  Character.getNumericValue(compuShips[i][k].charAt(1));
                       y =  Character.getNumericValue(compuShips[i][k].charAt(4));
                      panelGrid.setColor(Color.black);        
                      panelGrid.fillRect(y*UNIT_SIZE,x*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
               }
              }
            }
        }else if(this.playerName == "Player"){
               for(int i=0;i< playerShips.length;i++){
                 for(int j=0;j< playerShips[i].length;j++){
                   for(int k=0;k< playerShips[i].length;k++){
                    x =  Character.getNumericValue(playerShips[i][k].charAt(1));
                    y =  Character.getNumericValue(playerShips[i][k].charAt(4));
                   panelGrid.setColor(Color.black);        
                   panelGrid.fillRect(y*UNIT_SIZE,x*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
               }
              }
            }
    }

    }
}