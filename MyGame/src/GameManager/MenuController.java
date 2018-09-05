package GameManager;

import View.MenuWindow;
import View.WindowInterface;
import View.WindowState;

import java.awt.*;

public class MenuController {
    private Background background;
    private MenuWindow mw;

    private WindowState gc;

    public MenuController(WindowState gc) {
        this.gc = gc;



    }


    public void moveToGame(){
        gc.setState(WindowState.gameWindow);
    }


}
