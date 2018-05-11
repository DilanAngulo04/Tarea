package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 8; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Running"+i+".png")));
        }
        super.setSprite(sprite);
    }//end setSprite

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        int x = 100;
        while (true) {
            try {           
                for(int i = 0; i <= 7; i++){
                    super.setImage(sprite.get(i));
                    super.setX(x);
                    Thread.sleep(80);
                    x+=10;
                }
//                System.out.println(x);
                if(x == 900 || x == 880){
                    x=0;
                }
                
            } catch (InterruptedException ex) {
                System.err.println("...ERROR");
            }
        }
    }//end run
}
