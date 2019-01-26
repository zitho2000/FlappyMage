package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;

public class Turbo extends Item {


    public Turbo(){
        super();
        this.texture= new Texture("core/assets/png/item_rot.png");
    }
    public void activate() {
    this.active=true;



    }
    public void deactivate(){
        this.active= false;

    }
}
