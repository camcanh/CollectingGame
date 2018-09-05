package View;
import GameManager.Background;
import GameManager.MenuController;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;

public class MenuWindow extends WindowInterface  {
    private static final long serialVersionUID = 1160966536873193351L;
    WindowState gc;
    private MenuController mn;
    private Background bg;
    private Color titleColor;
    private Font titleFont;
    private Font font;

    private int currentChoice = 0;
    private String[] options = {
            "Start",
            "Help",
            "Quit"
    };


    public MenuWindow(WindowState gc) {
        this.gc = gc;


        init();

    }

    public void init() {

        mn = new MenuController(gc);
        bg = new Background("/background.png", 1);
        bg.setVector(-0.1, 0);
        titleColor = new Color(128, 42, 7);
        titleFont = new Font(
                "Courier New",
                Font.BOLD,
                28);

        font = new Font("Arial", Font.PLAIN, 12);
    }
    public void update(){
        bg.update();
    }
   // @Override
    public void makeGraphic(Graphics2D g2d) {
        // draw bg
        bg.draw(g2d);

        // draw title
        g2d.setColor(titleColor);
        g2d.setFont(titleFont);
        g2d.drawString("Running Game", 70, 70);

        // draw menu options
        g2d.setFont(font);
        for(int i = 0; i < options.length; i++) {
            if(i == currentChoice) {
                g2d.setColor(Color.BLACK);
            }
            else {
                g2d.setColor(Color.RED);
            }
            g2d.drawString(options[i], 145, 140 + i * 15);
        }



    }

    private void select() {
        if(currentChoice == 0) {
            mn.moveToGame();
        }
        if(currentChoice == 1) {
            // help
        }
        if(currentChoice == 2) {
            System.exit(0);
        }
    }
    @Override
    public void keyPressed(int i) {
        if(i == KeyEvent.VK_ENTER){
            select();
        }
        if(i == KeyEvent.VK_UP) {
            currentChoice--;
            if(currentChoice == -1) {
                currentChoice = options.length - 1;
            }
        }
        if(i == KeyEvent.VK_DOWN) {
            currentChoice++;
            if(currentChoice == options.length) {
                currentChoice = 0;
            }
        }
    }
    @Override
    public void keyReleased(int i) {}


}
