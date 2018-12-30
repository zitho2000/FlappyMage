package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;

public class Turbo extends Item {


    public Turbo(float x,float y){
        super(x,y);
        this.texture= new Texture("core/assets/png/item_rot.png");
    }
    void activate() {

    }
}
