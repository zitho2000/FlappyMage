package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract   class Obstacle {
    public Vector2 position;
    Vector2 size;               //Größe
    Rectangle hitbox;           //treffbarer Rahmen
    public Texture texture;     //Texture
    public boolean countet;     //bereits gezählt
    public boolean resizable;   //Größe veränderbar
    public boolean hitted;      //bereits getroffen


    public Obstacle(float x) {
        this.position=new Vector2(x,0);
        hitted=false;
        countet=false;
        resizable=true;
    }

    public Vector2 getSize() {
        return this.size;
    }

    public Vector2 getPosition() {
        return position;
    }

    public  void setPosition(float x,float y){
        this.position=new Vector2(x,y);
        this.hitbox.x=x;
        this.hitbox.y=y;
    }
    //nach links bewegen, um Scrollscreen zu schaffen
    public void moveLeft (double x){
        this.position.x-=x;
        this.hitbox.x-=x;
    }

   abstract void reposition();
   abstract void resize(float height);
}
