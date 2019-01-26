package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract   class Obstacle {
    private Vector2 position;
    Vector2 size;
    Rectangle hitbox;
    public Texture texture;


    public Obstacle(float x, float y) {
        this.position =new Vector2(x,y);
    }

    public Vector2 getSize() {
        return size;
    }

    public Vector2 getPosition() {
        return position;
    }

    public  void setPosition(float x,float y){
        this.position.x=x;
        this.hitbox.x=x;
    }

    public void moveLeft (int x){
        this.position.x-=x;
        this.hitbox.x-=x;
    }
   abstract void reposition();
}
