package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;

public class Invulnerablility extends Item {
    public Invulnerablility(float x,float y){
        super(x,y);
        this.texture= new Texture("core/assets/png/item_gruen.png");
    }
}
