package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Mage {

    private static final int UP = 80;

    private Vector2 position;
    public boolean alive;
    private Vector2 size;
    public Rectangle hitbox;
    public Texture texture;
    public Texture Rakete;


    public Mage(int x, int y) {
        position = new Vector2(x, y);
        alive = true;
        size = new Vector2(100, 100);

        texture = new Texture("core/assets/png/harry.png");
        hitbox = new Rectangle(this.position.x, this.position.y,this.size.x, this.size.y );
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(float x, float y) {
        this.position = new Vector2(x, y);
        this.hitbox.x=x;
        this.hitbox.y=y;
    }

    public void setHalfSize() {
        this.size.scl(0.5f);
    }

    public void resetSize() {
        this.size.scl(2);
    }


    public void fall(int gravity) {
        position.y -= gravity;
        hitbox.y-= gravity;
    }

    public void flyUp() {
        position.y += UP;
        hitbox.y+=UP;
    }
    public void die(){
        this.alive=false;
    }

    public Vector2 getSize() {
        return size;
    }
}