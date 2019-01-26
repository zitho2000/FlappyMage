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

    public Mage(int x, int y) {
        position = new Vector2(x, y);
        alive = true;
        size = new Vector2(50, 50);

        texture = new Texture("core/assets/png/harry.png");
        hitbox = new Rectangle(position.x, position.y,(float)(texture.getWidth()*0.125), (float)(texture.getHeight()*0.125) );
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

}