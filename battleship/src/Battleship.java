import java.util.*;

public class Battleship {
    //vars 
    String[] carrier;
    public static String[] ships;
    String x;
    String y;
    int shipLength;

    Battleship (){
        carrier = new String[1];
        ships = new String[3];
    }


    public void shipGenerator(){
            String x;
            String y;
            String[] coordenates = new String[2];
            for(int i=0; i < ships.length;i++){
                Random ran = new Random();
                x = Integer.toString(ran.nextInt(10));
                y = Integer.toString(ran.nextInt(10));
                coordenates[0] = x;
                coordenates[1] = y;
                ships[i] = Arrays.toString(coordenates);
            }
            System.out.print(Arrays.toString(ships));
        }


    }
