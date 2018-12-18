package de.uniulm.flappywizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {

    final FlappyWizardGame game;

    OrthographicCamera camera;

    public GameScreen(FlappyWizardGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
    }

    Mage mage = new Mage(200, 200);
    Item item = new Item(200, 400);

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub
        Gdx.gl.glClearColor(0, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        int harry_width = (int) (game.harry.getWidth() * 0.125);
        int harry_height = (int) (game.harry.getHeight() * 0.125);

        mage.fall();
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            mage.flyUp();
        }
        if (mage.hitbox.overlaps(item.hitbox)) {
            item.turnRed();
        }
        if (mage.hitbox.overlaps(item.hitbox)==false){
            item.turnBlue();
        }
        game.batch.begin();
        game.batch.draw(game.harry
                , mage.getPosition().x
                , mage.getPosition().y
                , harry_width
                , harry_height
        );
        game.batch.draw(item.texture
                , item.getPosition().x
                , item.getPosition().y
                , item.hitbox.width
                , item.hitbox.height
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
