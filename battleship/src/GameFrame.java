import java.awt.Color;
import java.awt.Container;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GameFrame extends JFrame implements ActionListener{
    //vars 
    int width = 800;
    int height = 600;
    Board compuBoard;
    Board playerBoard;
    JTextField textField;
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
        // JLabel playerLabel = new JLabel("PUTO");
        // playerLabel.setBounds(100, 30, 80, 30);
        // playerBoard.setBackground(Color.yellow);
        // playerBoard.add(playerLabel);


        // Computer Board label
       JLabel compuLabel =new JLabel("Compu");
       compuLabel.setBounds(100, 30, 80, 30);
       compuBoard.add(compuLabel);

       // ADD BOARDS INTO CONTAINERS
       //playerContainer.add(playerBoard);
       //compuContainer.add(compuBoard);

       // Text field
       this.textField = new JTextField(8);
       textField.setBounds(250, 400, 280, 30); // to get height, set large font
       textField.setFont(textField.getFont().deriveFont(20f));
       textField.addKeyListener(new MyKeyAdapter());
; // "this" is implementing ActionListener 
       this.add(textField);

       this.add(playerBoard);
       this.add(compuBoard);
        addKeyListener(new MyKeyAdapter());

       this.setVisible(true);
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            String userGuess;
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                userGuess = textField.getText();
               // System.out.print(userGuess);
                Game.takeTurn(userGuess);
            }

        }

   }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
