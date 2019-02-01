package de.uniulm.flappywizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HighScoreScreen implements Screen {

    final FlappyWizardGame game;
    OrthographicCamera camera;

    private Stage stage;
    private Label nameLabel;        //Namensanzeige
    private Label scoreLabel;       //erreichte Punkte
    private Image gimage;           //Gold-Medaille
    private Image simage;           //Silber-Medaille
    private Image bimage;           //Bronze-Medaille
    private ImageButton back;       //zurück-Button

    public HighScoreScreen(final FlappyWizardGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        stage = new Stage();


        //Highscore-Daten auslesen
        String[] first = new String[2];
        String[] second = new String[2];
        String[] third = new String[2];
        try {
            BufferedReader rb = new BufferedReader(new FileReader("core/Highscore.txt"));
            first = rb.readLine().split(" ");
            second = rb.readLine().split(" ");
            third = rb.readLine().split(" ");

        } catch (IOException e) {
        }


        //Highscore-Daten aufschreiben
        BitmapFont font = new BitmapFont();
        font.getData().setScale(5);
        nameLabel = new Label("Name" + "\r\n\n" + first[0] + "\r\n\n" + second[0] + "\r\n\n" + third[0], new Label.LabelStyle(font, Color.WHITE));
        nameLabel.setPosition(1280 / 2 - nameLabel.getPrefWidth() / 2 - 150, 720 / 2 - nameLabel.getPrefHeight() / 2);
        scoreLabel = new Label("Score" + "\r\n\n" + first[1] + "\r\n\n" + second[1] + "\r\n\n" + third[1], new Label.LabelStyle(font, Color.WHITE));
        scoreLabel.setPosition(1280 / 2 - nameLabel.getPrefWidth() / 2 + 350, 720 / 2 - nameLabel.getPrefHeight() / 2);

        //Medaillen erstellen
        gimage = new Image(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/Goldmedall.png"))));
        simage = new Image(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/Silvermedall.png"))));
        bimage = new Image(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/Bronzemedall.png"))));
        gimage.setPosition(1280 / 2 - 600, 720 / 2 + 40);
        simage.setPosition(1280 / 2 - 600, 720 / 2 - 150);
        bimage.setPosition(1280 / 2 - 600, 720 / 2 - 310);

        back = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/ZurückButton.png"))));
        back.setPosition(20, 720 - 80);

        //zurück-Button geklickt
        back.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                dispose();
                game.setScreen(new MainMenuScreen(game));
            }
        });

        stage.addActor(nameLabel);
        stage.addActor(scoreLabel);
        stage.addActor(gimage);
        stage.addActor(simage);
        stage.addActor(bimage);
        stage.addActor(back);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(100 / 255f, 127 / 255f, 127 / 255f, 1);
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
    public void dispose() {
        stage.dispose();
    }
}
