package View;

import Entity.Character;

public class WindowState {
    private Character character;
    private WindowInterface[] gs;
    private  int currentState;

    public static final int menuWindow = 0;
    public static final int gameWindow = 1;
    public static final int gameOverWindow = 2;
    public static final int loseWindow = 3;


    public WindowState() {
        gs = new WindowInterface[4];

        currentState = menuWindow;
        loadState(currentState);

    }

    public void loadState(int s){
        if(s == menuWindow) {
            gs[s] = new MenuWindow(this);

        }
        else if (s == gameWindow) {
            gs[s] = new Game1Window(this);

        }
        else if (s == gameOverWindow) {
            gs[s] = new GameOver(this);
        }
        else if(s == loseWindow) {
            gs[s] = new LoserWindow(this);
        }
    }

    private void unloadState(int s) {
        gs[s] = null;
    }

    public void setState(int state) {
        unloadState(currentState);
        currentState = state;
        loadState(currentState);
    }

    public void update() {
        try {
            gs[currentState].update();
        } catch(Exception e) {}
    }

    public void draw(java.awt.Graphics2D g) {
        try {
            gs[currentState].makeGraphic(g);
        } catch(Exception e) {}
    }

    public void keyPressed(int k) {
        gs[currentState].keyPressed(k);
    }

    public void keyReleased(int k) {
        gs[currentState].keyReleased(k);
    }





}
