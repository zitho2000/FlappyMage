package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Dementor extends Obstacle {


    public Dementor(float x, float y) {
        super(x,500);
        this.texture= new Texture("core/assets/png/dementor.png");
        this.hitbox=new Rectangle(this.getPosition().x,this.getPosition().y,texture.getWidth()*0.125f,(texture.getHeight()*0.125f)* ((float)Math.random()*2));

        size= new Vector2(hitbox.getWidth(),hitbox.getHeight());
        this.setPosition(x,720-this.size.y);
    }

    public Texture getTexture() {
        return texture;

    }

    void reposition(){
        this.hitbox=new Rectangle(this.getPosition().x,this.getPosition().y,texture.getWidth()*0.125f,(texture.getHeight()*0.125f)* ((float)Math.random()*2));

        size= new Vector2(hitbox.getWidth(),hitbox.getHeight());

        this.setPosition(1280,720-this.size.y);
    }


}
