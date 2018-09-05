package Entity;

import GameManager.GameController;

import javax.swing.*;
import java.awt.*;

public class YellowCoins extends MapObject {
    private Image image;
    private boolean gone;




    public YellowCoins(GameController gc) {
        super(gc);
        cwidth = 20;
        cheight = 20;
        init();
    }

    public void init() {
        ImageIcon img = new ImageIcon("D:\\Fachhochschule Frankfurt 3rd year exchange\\Wintersemester\\OOP Java\\MyGame\\Resources\\yellowcoin2.gif");
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