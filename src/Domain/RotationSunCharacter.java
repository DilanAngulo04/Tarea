/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author dilan_000
 */
public class RotationSunCharacter extends Character {

    public RotationSunCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        
            sprite.add(new Image(new FileInputStream("src/Assets/RotationSun0.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/RotationSun1.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/rotationSun2.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/RotationSun3.png")));
        
        System.out.println(sprite.size());
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        
        while (true) {
            try {
                super.setImage(sprite.get(0));
                Thread.sleep(250);
                super.setImage(sprite.get(1));
                Thread.sleep(250);
                super.setImage(sprite.get(2));
                Thread.sleep(250);
                super.setImage(sprite.get(3));
                Thread.sleep(250);
                
            } catch (InterruptedException ex) {
                System.err.println("...ERROR");
            }
        }
    }

}
