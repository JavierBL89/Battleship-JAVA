import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class GameFrame extends JFrame{
    //vars 
    int width = 800;
    int height = 600;
    Board compuBoard;
    Board playerBoard;
    //constructor
    GameFrame(){
        // set window
        this.setSize(width, height);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setLayout(null);

        // Conatiner will create a container to host each board(panel)
        // Container compuContainer = getContentPane();
        // Container playerContainer = getContentPane();

        // Create boards
        compuBoard = new Board("Compu");
        playerBoard  = new Board("Player");

        // Board attributes
        compuBoard.setLayout(null);
        playerBoard.setLayout(null);
        playerBoard.setBorder(BorderFactory.createLineBorder(Color.black));
        compuBoard.setBorder(BorderFactory.createLineBorder(Color.black));
        playerBoard.setBackground(Color.yellow);
        compuBoard.setBackground(Color.red);
        playerBoard.setBounds(410, 100, 201, 200);
        compuBoard.setBounds(190, 100, 201, 200);
       // compuBoard.setBounds(400, 100, 181, 181);

        // Player Board label
        JLabel playerLabel = new JLabel("PUTO");
        playerLabel.setBounds(100, 30, 80, 30);
        playerBoard.setBackground(Color.yellow);
        playerBoard.add(playerLabel);


        // Computer Board label
       JLabel compuLabel =new JLabel("Sayonara");
       compuLabel.setBounds(100, 30, 80, 30);
       compuBoard.add(compuLabel);

       // ADD BOARDS INTO CONTAINERS
       //playerContainer.add(playerBoard);
       //compuContainer.add(compuBoard);
        
       this.add(playerBoard);
       this.add(compuBoard);
       this.setVisible(true);
    }
    
}
