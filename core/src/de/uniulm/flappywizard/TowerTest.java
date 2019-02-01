package de.uniulm.flappywizard;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TowerTest {

    @Test
    void getPosition(float yPosition) {
        assertEquals(0,yPosition);
    }

    @Test
    void reposition(float yPosition) {
        assertEquals (0,yPosition);
    }

}