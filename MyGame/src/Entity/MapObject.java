package Entity;

import GameManager.GameController;
import Main.GamePanel;

import java.awt.Rectangle;

public abstract class MapObject {
    protected GameController gameController;
    protected int tileSize;

    protected double xmap;
    protected double ymap;

    protected int width;
    protected int height;
    protected int cwidth;
    protected int cheight;

    //movement
    protected boolean left;
    protected   boolean right;
    protected boolean up;
    protected boolean down;
    protected boolean jumping;
    protected boolean falling;

    protected double x;
    protected double y;
    protected double dx  ; //displacement of x
    protected double dy  ; //displacement of y









    public MapObject(GameController gm){
        gameController = gm;
        tileSize = gm.getTileSize();

    }


    public int getX(){
        return (int)x;
    }
    public int getY(){
        return (int)y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public int getCheight() {
        return cheight;
    }

    public int getCwidth() {
        return cwidth;
    }

    public Rectangle newRectangle(){
        return new Rectangle((int)x - cwidth, (int)y - cheight, cwidth, cheight);
    }

    public boolean intersects(MapObject object){
        Rectangle r1 = newRectangle();
        Rectangle r2 = object.newRectangle();
        return r1.intersects(r2);
    }


    public void setPosition(double x, double y){
        this.x = x;
        this.y = y;

    }

    public void setVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;

    }

    public void positionInMap (){
        xmap = gameController.getx();
        ymap = gameController.gety();
    }

    public void setLeft(boolean b) {
        left = b;
    }
    public void setRight(boolean b) {
        right = b;
    }
    public void setUp(boolean b) {
        up = b;
    }
    public void setDown(boolean b) {
        down =b ;
    }

    public void setJumping(boolean b) {
        jumping = b;
    }



}
