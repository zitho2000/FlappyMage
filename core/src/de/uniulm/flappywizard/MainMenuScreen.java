package de.uniulm.flappywizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import javax.xml.soap.Text;

public class MainMenuScreen implements Screen {

    final FlappyWizardGame game;

    OrthographicCamera camera;

    ImageButton start =new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/SpielStartenButton.png"))));
    ImageButton highScore =new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/HighScoreButton.png"))));
    ImageButton help =new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/HilfeButton.png"))));
    ImageButton quit =new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/SpielBeenden.png"))));

    Stage stage = new Stage();





    public MainMenuScreen(final FlappyWizardGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        stage.addActor(start);
        stage.addActor(highScore);
        stage.addActor(help);
        stage.addActor(quit);

        start.setPosition(camera.viewportWidth / 2 - start.getWidth() / 2, camera.viewportHeight / 2 - start.getHeight() / 2 + 150);
        highScore.setPosition(camera.viewportWidth / 2 - highScore.getWidth() / 2, camera.viewportHeight / 2 - highScore.getHeight() / 2 + 50);
        help.setPosition(camera.viewportWidth / 2 - help.getWidth() / 2, camera.viewportHeight / 2 - help.getHeight() / 2 - 50);
        quit.setPosition(camera.viewportWidth / 2 - quit.getWidth() / 2, camera.viewportHeight / 2 - quit.getHeight() / 2 - 150);


        start.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("clicked");
                game.setScreen(new GameScreen(game));
                dispose();
            }
        });

        Gdx.input.setInputProcessor(stage);
    }




    @Override
    public void render(float delta) {





        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        game.batch.begin();
        stage.draw();
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
