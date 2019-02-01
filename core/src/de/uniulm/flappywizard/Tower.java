package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Tower extends Obstacle{


    Texture texture1;
    Texture texture2;
    Texture texture3;
    Texture texture4;

    public Tower(float x) {
        super(x);


        this.texture1= new Texture(("core/assets/png/turm_gryffindor.png"));
        this.texture2= new Texture(("core/assets/png/turm_ravenclaw.png"));
        this.texture3= new Texture(("core/assets/png/turm_huffelpuff.png"));
        this.texture4= new Texture(("core/assets/png/turm_slytherin.png"));

        //Haus des Turm wird zufällig ausgewählt
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

        this.size=new Vector2(150,250* ((float)Math.random())+180);
        this.position.y=0;
        this.hitbox=new Rectangle(this.getPosition().x,this.getPosition().y,this.size.x,this.size.y);


    }
    // Repositionierung am rechten Bildschirmrand
    void reposition(){
        this.countet=false;
        this.resizable=true;
        this.hitted=false;
        int rng= (int) (Math.random()*4 +1);
        if (rng==1){
            this.setTexture( texture1);}
        else if (rng==2 ){
            this.texture=texture2;}
        else if (rng==3 ){
            this.texture=texture3;
        }
        else {
            this.texture= texture4;
        }
        this.size.y=250* ((float)Math.random())+180;
        this.position.x=this.position.x+3200;
        this.hitbox=new Rectangle(this.getPosition().x,this.getPosition().y,this.size.x,this.size.y);
    }

    //Größenänderung
    void resize(float height) {
        if (this.resizable) {
            this.size.y = height;
            this.hitbox = new Rectangle(this.getPosition().x, this.getPosition().y, this.size.x, this.size.y);
            this.resizable=true;
        }
    }
}
