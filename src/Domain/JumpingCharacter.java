package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {

    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 3; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Jumping" + i + ".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int y = 370;
        while (true) {
            try {
                super.setImage(sprite.get(2));
                Thread.sleep(400);
                if (y == 370) {
                    super.setImage(sprite.get(0));
                    while (y >= 270) {
                        y -= 10;
                        this.setY(y);
                        Thread.sleep(40);
                    }
                }
                if (y == 260) {
                    super.setImage(sprite.get(1));
                    while (y <= 370) {
                        y += 10;
                        this.setY(y);
                        Thread.sleep(40);
                    }
                }
                y -= 10;

                this.setY(y);
            } catch (InterruptedException ex) {
                System.err.println("...ERROR");
            }
        }
    }
}
