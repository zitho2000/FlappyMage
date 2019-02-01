package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;

public class Troll extends Item {
    public Troll() {
        super();
        this.setTexture(new Texture("core/assets/png/item_blau.png"));
    }

    public void activate() {

        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }
}
