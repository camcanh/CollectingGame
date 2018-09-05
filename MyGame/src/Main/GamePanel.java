package Main;

import View.WindowState;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyListener;

import java.awt.image.BufferedImage;
import java.awt.event.*;



public class GamePanel extends JPanel implements Runnable, KeyListener {

    private WindowState gc;
    //dimension
    public static final int WIDTH = 320;
    public static final int HEIGHT =240;
    public static final int SCALE =2;

    //thread
    private Thread thread;
    private boolean running;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;

    private BufferedImage image;
    private Graphics2D graphics;

    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify() {
        super.addNotify();
        if(thread == null) {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    public void init (){
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        graphics = (Graphics2D) image.getGraphics();
        running = true;

        gc = new WindowState();


    }

    @Override
    public void run() {
        init();
        long start;
        long elapsed;
        long wait;


        while (running) {
            start = System.nanoTime();
            update();
            draw();
            drawScreen();
            elapsed = System.nanoTime() - start;

            wait = targetTime - elapsed / 1000000;
            if(wait < 0) wait = 5;

            try {
                Thread.sleep(wait);
            }
            catch(Exception e) {
                e.printStackTrace();
            }


        }



    }
    public void draw(){
        gc.draw(graphics);
    }

    public void update(){
        gc.update();

    }
    public void drawScreen(){
        Graphics gr = getGraphics();
        gr.drawImage(image,0,0, WIDTH * SCALE, HEIGHT * SCALE,null);
        gr.dispose();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        gc.keyPressed(e.getKeyCode());

    }


    public void keyReleased(KeyEvent e) {
        gc.keyReleased(e.getKeyCode());

    }


    public void keyTyped(KeyEvent e) {

    }
}
