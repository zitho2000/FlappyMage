package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Tower extends Obstacle{


    public Tower(float x, float y) {
        super(x,0);
        int rng= (int) (Math.random()*4 +1);
        if (rng==1){
        this.texture= new Texture("core/assets/png/turm_gryffindor.png");}
        else if (rng==2 ){
            this.texture= new Texture("core/assets/png/turm_ravenclaw.png");
        }
        else if (rng==3 ){
            this.texture= new Texture("core/assets/png/turm_huffelpuff.png");
        }
        else {
            this.texture= new Texture("core/assets/png/turm_slytherin.png");
        }
        this.hitbox=new Rectangle(x,0,texture.getWidth()*0.125f,texture.getHeight()*0.125f* ((float)Math.random()*2));
        size= new Vector2(hitbox.getWidth(),hitbox.getHeight());

    }

    void reposition(){

        this.hitbox=new Rectangle(this.getPosition().x,0,texture.getWidth()*0.125f,texture.getHeight()*0.125f* ((float)Math.random()*2));
        size= new Vector2(hitbox.getWidth(),hitbox.getHeight());
        this.setPosition(1280,0);
    }

}
