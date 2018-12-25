package de.uniulm.flappywizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {

    final FlappyWizardGame game;
    final int SCROLLSPEED = 5;

    OrthographicCamera camera;
    Mage mage = new Mage(200, 200);
    Dementor dementor = new Dementor(300, 0);
    Tower tower = new Tower(300, 432423);
    Troll troll = new Troll(300, 300);

    public GameScreen(FlappyWizardGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
    }

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub
        Gdx.gl.glClearColor(0, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        dementor.moveLeft(SCROLLSPEED);
        mage.fall();
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            mage.flyUp();
        }

        game.batch.begin();
        game.batch.draw(mage.texture
                , mage.getPosition().x
                , mage.getPosition().y
                , mage.hitbox.width
                , mage.hitbox.height

        );
        game.batch.draw(troll.texture
                , troll.getPosition().x
                , troll.getPosition().y
                , troll.hitbox.width
                , troll.hitbox.height);
        game.batch.draw(dementor.texture
                , dementor.getPosition().x
                , dementor.getPosition().y
                , dementor.hitbox.width
                , dementor.hitbox.height
        );
        game.batch.draw(tower.texture
                , tower.getPosition().x
                , tower.getPosition().y
                , tower.hitbox.width
                , tower.hitbox.height
        );

        game.batch.end();

    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }

}
