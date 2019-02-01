package de.uniulm.flappywizard;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    @Test
    void testMageSize( Rectangle hitbox ,Vector2 size) {


        assertEquals(size.x,hitbox.getWidth());
        assertEquals(size.y,hitbox.getHeight());
    }


}