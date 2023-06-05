import java.awt.Graphics;

import javax.swing.JFrame;

public class Game {

    
    public static void main(String[] args) throws Exception {
        GameFrame game = new GameFrame();
        Battleship sg = new Battleship();
        sg.shipGenerator();
        Board b;
        b = new Board();
       // b.newBoard();
       //b.updateBoardTest("puta",2, 2);
        
    }
}
