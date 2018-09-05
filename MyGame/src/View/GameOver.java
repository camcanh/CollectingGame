package View;
import Entity.Character;
import GameManager.Background;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOver extends WindowInterface{
    private static final long serialVersionUID = 1160966536873193351L;

    WindowState gc;
    private Character character;
    private Background bg;
    private Font titleFont;
    private String s ;
    JTextField tf;



    public GameOver(WindowState ws)
    {
        this.gc = ws;



        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(250, 250);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        JLabel label = new JLabel("Congratulation, You are the winner!!!" );
        label.setBounds(50,100, 250,20);
        JLabel tf = new JLabel();
        tf.setBounds(50,150,250,20);

        window.add(label);
        window.add(tf);
        window.setVisible(true);
        window.setLayout(null);
        window.setVisible(true);
        window.setTitle("Congratulation");






    }
    public void getPoints() {

        int a = (character.getCurrentLife()) * 2;
        int b = (character.getCurrentPoints());
        int c = a + b;
        tf.setText(Integer.toString(c));


    }







    public  void init(){




    }
    public  void update(){
//        bg.update();


    }
    public  void makeGraphic(Graphics2D g2d){

    }


    public  void keyPressed(int i){
        if (i== KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        else  if (i == KeyEvent.VK_ENTER) {
            gc.setState(WindowState.menuWindow);
        }
    }
    public  void keyReleased(int i){}
}
