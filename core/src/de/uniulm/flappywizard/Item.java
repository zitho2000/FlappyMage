package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Item {
     private Vector2 position;
     public Rectangle hitbox;
     private Vector2 size;
     public Texture texture;
     public boolean active;

     public Item(){
         this.position=new Vector2(100000,100000);
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
    public void moveLeft (int x){
         this.setPosition(this.getPosition().x-x,this.getPosition().y);
         this.hitbox.x-=x;
    }
     public abstract void activate();
     public abstract void deactivate();

    public Vector2 getSize() {
        return size;
    }
}
