package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;

public class Troll extends Item {
    public Troll(float x,float y){
        super(x,y);
        this.texture= new Texture("core/assets/png/item_blau.png");
    }
}
