package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract   class Obstacle {
    public Vector2 position;
    Vector2 size;
    Rectangle hitbox;
    public Texture texture;
    public boolean countet;
    public boolean resized;
    public boolean hitted;


    public Obstacle(float x) {
        this.position=new Vector2(x,0);
        hitted=false;
        countet=false;
        resized=false;
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

    public void moveLeft (int x){
        this.position.x-=x;
        this.hitbox.x-=x;
    }
   abstract void reposition();
    abstract void resize(float height);
}
