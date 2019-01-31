package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;

public class Invulnerablility extends Item {

    public Invulnerablility(){
        super();
        this.texture= new Texture("core/assets/png/item_gruen.png");
    }

   public  void activate() {
       this.active=true;
    }
    public void deactivate(){
        this.active= false;
    }
}
