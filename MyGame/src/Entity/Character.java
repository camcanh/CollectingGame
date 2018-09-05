package Entity;

import GameManager.GameController;

import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Character extends MapObject {


    //playerstuff
    private int maxLife = 5;
    private int currentLife = 5;
    private boolean dead;
    private int currentPoints = 0;

    private Image image;

    // movement attributes
    private double moveSpeed;
    private double stopSpeed;
    private double fallSpeed;
    private double maxFallSpeed;
    private double jumpStart;
    private double stopJumpSpeed;







    public int getCurrentLife() {
        return currentLife;
    }

    public int getMaxLife() { return maxLife;}

    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public Character(GameController gm) {

        super(gm);


        initPlayer();


        cwidth = 20;
        cheight = 20;
        moveSpeed = 2;
        stopSpeed = 1;
        fallSpeed = 0.2;
        maxFallSpeed = 4.0;
        jumpStart = -5;
        stopJumpSpeed = 0.2;


    }

    public void initPlayer(){

            ImageIcon img = new ImageIcon("D:\\Fachhochschule Frankfurt 3rd year exchange\\Wintersemester\\OOP Java\\MyGame\\Resources\\char.png");
            image =  img.getImage();



    }

    public  void update() {
        newPosition();
        setPosition(x, y);
    }

    public Image getImage() {
        return image;
    }

    private void newPosition() {
        if(left) {
            dx = moveSpeed;
            x -= dx;
        }
        else if (right) {
            dx = moveSpeed;
            x += dx;
        }

        else {
            if (dx > 0) {
                dx -= stopSpeed;
                if (dx < 0 ) {
                    dx =0;
                }
            }
            else  if (dx < 0) {
                dx += stopSpeed;
                if (dx >0) {
                    dx = 0;
                }
            }

        }

        if(jumping && !falling) {
             dy = jumpStart;
             y += dy;
             falling = true;
        }
        if(falling) {

            dy += fallSpeed;
            if (dy > 0) {jumping = false;}
            if(dy < 0 && !jumping) {dy += stopJumpSpeed;}

            if(dy > maxFallSpeed) dy = maxFallSpeed;
            if ( y > 178) {
                dy = 0;
                y =178;
                falling = !falling;
            }
            y += dy;




        }

    }

    public void draw (Graphics2D g){
        positionInMap();
        g.drawImage(image,(int)(x + xmap - width / 2),
                (int)(y + ymap - height / 2), null);


    }









}