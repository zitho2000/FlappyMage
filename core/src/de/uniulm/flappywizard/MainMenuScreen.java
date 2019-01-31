package de.uniulm.flappywizard;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


public class MainMenuScreen implements Screen {

    final FlappyWizardGame game;

    OrthographicCamera camera;

    ImageButton start;          //Start-Knopf
    ImageButton highScore;      //Bestenliste-Knopf
    ImageButton help;           //Hilfe-Knopf
    ImageButton quit;           //Spiel verlassen-Knopf

    Stage stage;





    public MainMenuScreen(final FlappyWizardGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        this.stage = new Stage();

        this.start =new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/SpielStartenButton.png"))));
        this.highScore =new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/HighScoreButton.png"))));
        this.help =new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/HilfeButton.png"))));
        this.quit =new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/SpielBeenden.png"))));

        stage.addActor(start);
        stage.addActor(highScore);
        stage.addActor(help);
        stage.addActor(quit);

        //mittig platzieren
        start.setPosition(camera.viewportWidth / 2 - start.getWidth() / 2, camera.viewportHeight / 2 - start.getHeight() / 2 + 150);
        highScore.setPosition(camera.viewportWidth / 2 - highScore.getWidth() / 2, camera.viewportHeight / 2 - highScore.getHeight() / 2 + 50);
        help.setPosition(camera.viewportWidth / 2 - help.getWidth() / 2, camera.viewportHeight / 2 - help.getHeight() / 2 - 50);
        quit.setPosition(camera.viewportWidth / 2 - quit.getWidth() / 2, camera.viewportHeight / 2 - quit.getHeight() / 2 - 150);

        //Spiel starten geklickt
        start.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("clicked");

                dispose();
                game.setScreen(new GameScreen(game));

            }
        });

        //Hilfe geklickt
        help.addListener(new ChangeListener() {

            public void changed(ChangeEvent event, Actor actor) {

                dispose();
                game.setScreen(new HelpScreen(game));

            }
        });

        //Highscore geklickt
        highScore.addListener(new ChangeListener() {

            public void changed(ChangeEvent event, Actor actor) {

                dispose();
                game.setScreen(new HighScoreScreen(game));

            }
        });

        //Spiel verlassen geklickt
        quit.addListener(new ChangeListener() {

            public void changed(ChangeEvent event, Actor actor) {

                dispose();

                Gdx.app.exit();
                System.exit(-1);

            }
        });

        Gdx.input.setInputProcessor(stage);
    }




    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(100/255f, 127/255f, 127/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
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
        stage.dispose();
        // TODO Auto-generated method stub
    }

}
