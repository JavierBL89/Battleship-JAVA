import javax.swing.JPanel;
import java.awt.*;

public class Board extends JPanel {
    //vars
    int BOARD_WIDTH;
    int BOARD_HEIGHT;
    String grid [][];
    int UNIT_SIZE;

    //constructor
    Board(){
        UNIT_SIZE = 20;
        BOARD_WIDTH = 200;
        BOARD_HEIGHT = 200;
        grid = new String[10][10];
        this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        //this.setBackground(Color.black);
        
    };

    // public String[][] newBoard(){
    //     for(int i=0;i< grid.length;i++){
    //         for(int j=0;j< grid.length;j++){
    //             if(grid[i][j] == grid[0][0]){
    //                 grid[i][j] = " ";
    //             }
    //             else if(grid[i][j] == grid[i][0]){
    //                 grid[i][j] = Integer.toString(i);
    //             }else if(grid[i][j] == grid[0][j] ){
    //                 grid[i][j] = Integer.toString(j);
    //             }else{
    //                 grid[i][j] = "0";
    //             }
    //             System.out.print(grid[i][j]) ; 
    //             System.out.print(" ") ; 
    //         }
    //         System.out.println(" ") ; 
    //     }
    //  return grid;
    // };

    
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
        for(int i = 0; i < grid.length;i++){
            panelGrid.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, BOARD_HEIGHT - UNIT_SIZE);
            panelGrid.drawLine(0, i*UNIT_SIZE, BOARD_WIDTH - UNIT_SIZE, i*UNIT_SIZE);
              
        }
   
    }

}
