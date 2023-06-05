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
    Integer gameGrid [][];
    int UNIT_SIZE;

    //constructor
    Board(){
        UNIT_SIZE = 20;
        BOARD_WIDTH = 200;
        BOARD_HEIGHT = 200;
        grid = new String[10][10];
        gameGrid = new Integer[10][10];
        this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        //this.setBackground(Color.black);
        
    };

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
        String[] ships = Battleship.ships;

        for(int i = 0; i < gameGrid.length;i++){
            panelGrid.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, BOARD_HEIGHT - UNIT_SIZE);
            panelGrid.drawLine(0, i*UNIT_SIZE, BOARD_WIDTH - UNIT_SIZE, i*UNIT_SIZE);               
        }

        for(int i=0;i< ships.length;i++){
            //ships[i] = Integer.toString(i);
            for(int j=0;j< ships[i].length();j++){
                //System.out.print(ships[0].charAt(0) + "uuu");
                    x =  Character.getNumericValue(ships[i].charAt(1));
                    y =  Character.getNumericValue(ships[i].charAt(4));
              // System.out.print( ships[i].charAt(4) + "aaa ");
              //System.out.print( y + "ee ");
              panelGrid.setColor(Color.black);        
              panelGrid.fillRect(x*UNIT_SIZE, y*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE); 
           }
        }
        
  

    }


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
