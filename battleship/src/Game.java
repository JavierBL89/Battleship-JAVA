import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Game {


    public static void takeTurn(String userInput){
        String[] userGuess = new String[2];
       // userGuess = textField.getText().trim();
        userGuess[0] = userInput.substring(0, 1);
        userGuess[1] = userInput.substring(2, 3);
        System.out.print(userGuess[0] + " " +userGuess[1]);

    }
    
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
