package de.uniulm.flappywizard;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Mage {



    private Vector2 position;   //Postion
    public boolean alive;       //Zauberer am Leben/tot
    private Vector2 size;       //Größe
    private Rectangle hitbox;    //treffbarer Rahmen
    private Texture texture;     //Textur




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



    public void setSize(float x,float y) {
        this.size=new Vector2(x,y);
        this.hitbox.width=x;
        this.hitbox.height=y;
    }

    //fallen
    public void fall(int gravity) {
        position.y -= gravity;
        hitbox.y-= gravity;
    }

    //1 mal nach oben fliegen
    public void flyUp(int up) {
        position.y += up;
        hitbox.y+=up;
    }

    //tötet den Zauberer (RIP)
    public void die(){
        this.alive=false;
    }

    public Vector2 getSize() {
        return size;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public Texture getTexture() {
        return texture;
    }
}