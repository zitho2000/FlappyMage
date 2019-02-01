package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Item {


     private Vector2 position;   //Position
     private Rectangle hitbox;   //treffbarer Rahmen
     private Vector2 size;      //Größe
     private Texture texture;    //Textur
     public boolean active;     //Gegenstand aktiv/inaktiv

     public Item(){
         this.position=new Vector2(42,1000);
         size =new Vector2(50,50);
         this.hitbox=new Rectangle(this.position.x,this.position.y,this.size.x,this.size.y);
     }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(float x,float y) {
        this.position = new Vector2(x,y);
        this.hitbox.x=x;
        this.hitbox.y=y;
    }

    //nach links bewegen, um Scrollscreen zu schaffen
    public void moveLeft (double x){
         this.setPosition((float)(this.getPosition().x-x),this.getPosition().y);
         this.hitbox.x-=x;
    }

     public abstract void activate();
     public abstract void deactivate();

    public Vector2 getSize() {
        return size;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
