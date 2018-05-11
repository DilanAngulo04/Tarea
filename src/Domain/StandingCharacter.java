package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class StandingCharacter extends Character {

    public StandingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 4; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Standing" + i + ".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int contador = 0;
        while (true) {
            try {
                super.setImage(sprite.get(0));
                contador++;
                Thread.sleep(1200);
                for (int i = 1; i <= 2; i++) {
                    super.setImage(sprite.get(i));
                    contador++;
                    Thread.sleep(100);                    
                }

            } catch (InterruptedException ex) {
                System.err.println("...ERROR");
            }
        }
    }
}
