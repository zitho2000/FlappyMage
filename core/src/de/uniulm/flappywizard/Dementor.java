package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Dementor extends Obstacle {
    public Texture texture;

    public Dementor(float x, float y) {
        super(x, 720-(1698*0.125f));
        this.texture= new Texture("core/assets/png/dementor.png");
        this.hitbox=new Rectangle(x,y,texture.getWidth()*0.125f,texture.getHeight()*0.125f);
        size= new Vector2(texture.getWidth(),texture.getHeight());
    }

    public Texture getTexture() {
        return texture;

    }

//blabla
}
