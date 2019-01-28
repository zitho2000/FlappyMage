package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Tower extends Obstacle{


    Texture texture1= new Texture(("core/assets/png/turm_gryffindor.png"));
    Texture texture2= new Texture(("core/assets/png/turm_ravenclaw.png"));
    Texture texture3= new Texture(("core/assets/png/turm_huffelpuff.png"));
    Texture texture4= new Texture(("core/assets/png/turm_slytherin.png"));

    public Tower(float x) {
        super(x);
        int rng= (int) (Math.random()*4 +1);
        if (rng==1){
        this.texture= texture1;}
        else if (rng==2 ){
            this.texture= texture2;}
        else if (rng==3 ){
            this.texture=texture3;
        }
        else {
            this.texture= texture4;
        }

        this.size=new Vector2(150,300* ((float)Math.random())+200);
        this.position.y=0;
        this.hitbox=new Rectangle(this.getPosition().x,this.getPosition().y,this.size.x,this.size.y);


    }

    void reposition(){int rng= (int) (Math.random()*4 +1);
        if (rng==1){
            this.texture= texture1;}
        else if (rng==2 ){
            this.texture= texture2;}
        else if (rng==3 ){
            this.texture=texture3;
        }
        else {
            this.texture= texture4;
        }
        this.size.y=300* ((float)Math.random())+200;
        this.position.x=this.position.x+3200;
        this.hitbox=new Rectangle(this.getPosition().x,this.getPosition().y,this.size.x,this.size.y);


    }

}
