package View;

import Entity.*;
import Entity.Character;
import GameManager.Background;
import GameManager.GameController;

import  java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Main.GamePanel;

public class Game1Window extends WindowInterface {
    private Character character;
    private GameController gamemap;
    private Background bg;
    private ArrayList<YellowCoins> yc;
    private ArrayList<RedCoins> rc;
    private ArrayList<Obstacle> ob;
    private GameOver go;


    private HUD hud;



    public Game1Window(WindowState gc) {

        this.gc = gc;
        init();
    }

    public void init() {

        gamemap = new GameController(30, gc);
        gamemap.loadTiles("/grasstileset.gif");
        gamemap.loadMap("/level1-2.map");
        gamemap.setPosition(0, 0);

        bg = new Background("/gamebackground7.png", 0.1);

        character = new Character(gamemap);

        hud = new HUD(character);

        character.setPosition(100, 178);
        showYellowCoins();
        showRedCoins();
        showObstacles();



    }
    //location of yellowcoin
    public void showYellowCoins(){
        yc = new ArrayList<YellowCoins>();
        YellowCoins c;
        c = new YellowCoins(gamemap);
        c.setPosition(150, 178);
        Point[] points = new Point[] {
                new Point(200, 178),
                new Point(860, 178),
                new Point(1500, 178),
                new Point(1650, 178),
                new Point(1900, 178),
                new Point(2100, 158),
                new Point(2400, 178)
        };
        for (int i = 0; i < points.length; i++){
            c = new YellowCoins(gamemap);
            c.setPosition(points[i].x, points[i].y);
            yc.add(c);

        }
    }

    public void showRedCoins() {
        rc = new ArrayList<RedCoins>();
        RedCoins c;
        c = new RedCoins(gamemap);

        Point[] points = new Point[] {
                new Point(350, 178),
                new Point(700, 178),
                new Point(900, 138),
                new Point(1300, 148),
                new Point(1400, 178)
        };
        for (int i = 0; i < points.length; i++) {
            c = new RedCoins(gamemap);
            c.setPosition(points[i].x, points[i].y);
            rc.add(c);
        }

    }
    public void showObstacles() {
        ob = new ArrayList<Obstacle>();
        Obstacle m;
        m = new Obstacle(gamemap);
        Point[] points = new Point[] {
                new Point(830, 178),
                new Point(1450, 178),
                new Point(1800, 108),
                new Point(1800, 178),
                new Point(2000, 178),
                new Point(2200, 178),
                new Point(2230, 118),
                new Point(2300, 178)
        };

        for (int i = 0; i < points.length; i++) {
            m = new Obstacle(gamemap);
            m.setPosition(points[i].x, points[i].y);
            ob.add(m);
        }

    }

    public  void update(){
        character.update();

        gamemap.setPosition(
                GamePanel.WIDTH / 2 - character.getX(),
                GamePanel.HEIGHT / 2 - character.getY()
        );
        bg.setPosition(gamemap.getx(), gamemap.gety());
        touchYellowCoin();
        touchRedCoin();
        touchObstacles();
        gameOver();
        loseWindow();

    }
    public  void makeGraphic(Graphics2D g2d){
        bg.draw(g2d);

        // clear screen
        //g2d.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

        // draw tilemap
        gamemap.draw(g2d);
        //draw yellow coins
        for(int i = 0; i < yc.size(); i++){
            yc.get(i).draw(g2d);
        }

        //draw red coins
        for(int i = 0; i < rc.size(); i++){
            rc.get(i).draw(g2d);
        }
        //draw obstacle
        for(int i = 0; i < ob.size(); i++){
            ob.get(i).draw(g2d);
        }


        character.draw(g2d);

        hud.draw(g2d);
    }
    public void touchYellowCoin(){

        for(int i = 0; i < yc.size(); i++) {
            YellowCoins yellowCoins = yc.get(i);
            yellowCoins.update();
            if(yc.get(i).intersects(character)) {
                yc.remove(i);
                i--;
                int a = character.getCurrentPoints();
                character.setCurrentPoints(a + 1);
            }

        }


    }

    public void touchRedCoin(){
        for(int b = 0; b < rc.size(); b++) {
            RedCoins redCoins = rc.get(b);
            redCoins.update();
            double c = character.getY();
            if(rc.get(b).intersects(character)) {
                rc.remove(b);
                b--;
                int a = character.getCurrentPoints();
                character.setCurrentPoints(a - 1);
            }

        }

    }

    public void touchObstacles(){
        for(int i = 0; i < ob.size(); i++) {
            Obstacle obstacle = ob.get(i);
            obstacle.update();
            double c = character.getY();
            if(ob.get(i).intersects(character)) {
                ob.remove(i);

                i--;
                int a = character.getCurrentLife();
                character.setCurrentLife(a - 1);
            }

        }


    }

    public  void gameOver() {
        if (yc.size() == 0) {

            gamemap.moveToGameOver();

        }

    }

    public void loseWindow() {
        if(character.getCurrentLife() == 0) {
            gc.setState(WindowState.loseWindow);


        }
    }




    public  void keyPressed(int i){
        if (i== KeyEvent.VK_ESCAPE) {
            gamemap.backWindow();
        }
        if (i== KeyEvent.VK_LEFT){
            character.setLeft(true);
        }
        if (i== KeyEvent.VK_RIGHT){
            character.setRight(true);
        }
        if (i== KeyEvent.VK_UP){
            character.setUp(true);
        }
        if (i== KeyEvent.VK_DOWN){
            character.setDown(true);
        }
        if (i== KeyEvent.VK_SPACE){
            character.setJumping(true);
        }

    }
    public  void keyReleased(int i){
        if (i== KeyEvent.VK_LEFT){
            character.setLeft(false);
        }
        if (i== KeyEvent.VK_RIGHT){
            character.setRight(false);
        }
        if (i== KeyEvent.VK_UP){
            character.setUp(false);
        }
        if (i== KeyEvent.VK_DOWN){
            character.setDown(false);
        }
        if (i== KeyEvent.VK_SPACE){
            character.setJumping(false);
        }

    }







}
