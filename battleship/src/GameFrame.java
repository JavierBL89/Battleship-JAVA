import javax.swing.JFrame;

public class GameFrame extends JFrame{
    //vars 
    int width = 800;
    int height = 600;
    
    //constructor
    GameFrame(){
        this.setSize(width, height);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
}
