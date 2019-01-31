package de.uniulm.flappywizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class HelpScreen implements Screen {


    final FlappyWizardGame game;

    Stage stage;
    Image image;        //Hilfs-Erklärungen
    ImageButton back;   //zurück-Button

    OrthographicCamera camera;
    public HelpScreen(final FlappyWizardGame game) {
       this.game =game;

       camera= new OrthographicCamera();
       camera.setToOrtho(false, 1280, 720);


       stage = new Stage();
       back =new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/ZurückButton.png"))));
       image = new Image(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/HelpScreen.png"))));
       stage.addActor(image);
       stage.addActor(back);
       image.setPosition(0,0);
       back.setPosition(20,720-80);

       //zurück-Button geklickt
       back.addListener(new ChangeListener(){
           public void changed(ChangeEvent event, Actor actor){
               dispose();
               game.setScreen(new MainMenuScreen(game));
           }
       });

       Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {stage.dispose();
    }
}
