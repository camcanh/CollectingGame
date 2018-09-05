package View;

public abstract class WindowInterface {
    protected WindowState gc;

    public abstract void init();
    public abstract void update();
    public abstract void makeGraphic(java.awt.Graphics2D g2d);
    public abstract void keyPressed(int i);
    public abstract void keyReleased(int i);


}
x