package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Dementor extends Obstacle {


    public Dementor(float x) {
        super(x);
        this.texture= new Texture("core/assets/png/dementor.png");
        this.size=new Vector2(150,300 *((float)Math.random())+200);
        this.position.y=720-this.getSize().y;
        this.hitbox=new Rectangle(this.getPosition().x,this.getPosition().y,this.size.x,this.size.y);



    }

    public Texture getTexture() {
        return texture;

    }

    void reposition(){
        this.countet=false;
        float rng =(float)Math.random();

        this.size.y=300*rng+200;

        this.setPosition(this.getPosition().x+3200,720-this.getSize().y);

        this.hitbox=new Rectangle(this.getPosition().x,this.getPosition().y,this.size.x,this.size.y);




    }

    void resize(float height){
        this.size.y=height;
        this.setPosition(this.getPosition().x,720-this.getSize().y);
        this.hitbox=new Rectangle(this.getPosition().x,this.getPosition().y,this.size.x,this.size.y);

    }
}
