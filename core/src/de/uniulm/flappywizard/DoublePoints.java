package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;

public class DoublePoints extends Item {

    public DoublePoints() {
        super();
        this.setTexture(new Texture("core/assets/png/item_silber.png"));
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }
}
