package de.uniulm.flappywizard;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testHitbox(Rectangle hitbox, Vector2 size){
        assertEquals(hitbox.getHeight(),size.y);
        assertEquals(hitbox.getWidth(),size.x);
    }

}