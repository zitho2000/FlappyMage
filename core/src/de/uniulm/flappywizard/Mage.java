package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Mage{
    private static final int GRAVITY=25;
    private static final int UP=50;

    private Vector2 position;
    private boolean alive;
    private Vector2 size;
    private Rectangle hitbox;
    private Texture texture;

    public Mage(int x, int y) {
        position = new Vector2(x,y);
        alive=true;
        size=new Vector2(50,50);
        hitbox=new Rectangle(position.x,position.y,50,50);
        texture=new Texture("core/assets/png/harry.png");
    }


    public void setHalfSize() {
        this.size.scl(0.5f);
    }

    public void resetSize() {
        this.size.scl(2);
    }


    public void fall(){
        position.y-=GRAVITY;
    }

    public void flyUp() {
        position.y += UP;
    }
}