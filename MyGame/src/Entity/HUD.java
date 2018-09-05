package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class HUD {
    private Character character;

    private BufferedImage image;
    private Font font;

    public HUD(Character character) {
        this.character = character;
        try {
            image = ImageIO.read(
                    getClass().getResourceAsStream(
                            "/hud.gif"
                    )
            );
            font = new Font("Arial", Font.PLAIN, 14);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
        g.drawImage(image, 0, 10, null);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(character.getCurrentLife() + "/" + character.getMaxLife(), 30, 25);
        g.drawString(Integer.toString(character.getCurrentPoints()), 30, 45);
    }
}
