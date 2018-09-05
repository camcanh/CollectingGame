package View;

import javax.swing.*;

public class LoserWindow extends WindowInterface {
    WindowState gc;

    public LoserWindow(WindowState ws)
    {
        //this.character = character;
        this.gc = ws;


//        int a = (character.getCurrentLife()) * 2;
//        int b = (character.getCurrentPoints());
//        c = a + b;
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(250, 250);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        JLabel label = new JLabel("You are the loser" );
        label.setBounds(100,100, 250,20);


        window.add(label);
        window.setVisible(true);
        window.setLayout(null);
        window.setVisible(true);
        window.setTitle("Loser");


    }
    public  void init(){}
    public  void update(){}
    public  void makeGraphic(java.awt.Graphics2D g2d){}
    public  void keyPressed(int i){}
    public  void keyReleased(int i){}



}
