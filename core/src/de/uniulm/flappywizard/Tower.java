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
        this.hitbox=new Rectangle(x,y,texture.getWidth()*0.125f,texture.getHeight()*0.125f);
        size= new Vector2(texture.getWidth(),texture.getHeight());
    }



}
