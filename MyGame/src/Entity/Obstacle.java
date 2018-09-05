package Entity;

import GameManager.GameController;

import javax.swing.*;
import java.awt.*;

public class Obstacle extends MapObject {
    private Image image;
    private boolean gone;




    public Obstacle(GameController gc) {
        super(gc);
        cwidth = 15;
        cheight = 15;
        init();
    }

    public void init() {
        ImageIcon img = new ImageIcon("D:\\Fachhochschule Frankfurt 3rd year exchange\\Wintersemester\\OOP Java\\MyGame\\Resources\\newbomb.png");
        image =  img.getImage();


    }

    public Image getImage() {
        return image;
    }
    public boolean isGone(){return gone;}

    public void update (){}

    public void draw (Graphics2D g){
        positionInMap();
        g.drawImage(image,(int)(x + xmap - width / 2),
                (int)(y + ymap - height / 2), null);


    }




}
