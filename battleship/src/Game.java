import java.awt.Graphics;

import javax.swing.JFrame;

public class Game {

    
    public static void main(String[] args) throws Exception {
        Battleship createShips = new Battleship();
        createShips.setPlayerShips("Compu");
        createShips.setPlayerShips("Player");
        
        GameFrame game = new GameFrame();

        Board b;
        //b = new Board();
       // b.newBoard();
       //b.updateBoardTest("puta",2, 2);
        
    }
}
