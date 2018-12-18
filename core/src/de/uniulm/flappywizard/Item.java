package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Item {
     private Vector2 position;
     public Texture texture;
     public Texture texturer;
     public Texture textureb;
     public Rectangle hitbox;
     private Vector2 size;

     public Item(int x,int y){
         position=new Vector2(x,y);
         texture=new Texture( "core/assets/png/item_blau.png");
         textureb=new Texture("core/assets/png/item_blau.png");
         texturer=new Texture("core/assets/png/item_rot.png");


         size=new Vector2(texture.getWidth()*0.125f,texture.getHeight()*0.125f);
         hitbox=new Rectangle(position.x,position.y,size.x,size.y);
     }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(float x,float y) {
        this.position = new Vector2(x,y);
    }
    public void turnRed(){
         texture=texturer;
    }
    public void turnBlue(){
        texture=textureb;
    }
}
