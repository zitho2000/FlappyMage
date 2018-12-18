package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Item {
     private Vector2 position;
     public Texture texture;
     public Rectangle hitbox;
     private Vector2 size;

     public Item(int x,int y){
         position=new Vector2(x,y);
         texture=new Texture( "core/assets/png/item_blau.png");
         hitbox=new Rectangle(position.x,position.y,texture.getWidth(),texture.getHeight());
         size=new Vector2(hitbox.width,hitbox.height);
     }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(float x,float y) {
        this.position = new Vector2(x,y);
    }
    public void turnRed(){
         texture=new Texture("core/assets/png/item_rot.png");
    }
}
