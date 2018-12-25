package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Item {
     private Vector2 position;
     public Rectangle hitbox;
     private Vector2 size;
     public Texture texture;

     public Item(float x,float y){
         position=new Vector2(x,y);
         size =new Vector2(50,50);
         hitbox= new Rectangle(position.x,position.y,size.x,size.y);


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
    }
}
