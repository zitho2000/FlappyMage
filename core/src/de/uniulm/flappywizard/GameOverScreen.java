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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

import javax.xml.soap.Text;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GameOverScreen implements Screen {

    final FlappyWizardGame game;

    OrthographicCamera camera;

    int score;
    Stage stage=new Stage();
    BitmapFont textFieldFont= new BitmapFont();
    Image popUp;
    TextField input;
    ImageButton ok;

    public GameOverScreen(final FlappyWizardGame game, int score) {
        this.game=game;
        camera= new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        ok =new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/OkButton.png"))));
        popUp=new Image(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/HighscorePopup.png"))));
        input =new TextField("",new TextField.TextFieldStyle(textFieldFont,Color.BLACK,new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/cursor.png"))),null,new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/png/Textfield.png")))));

        this.score=score;
        input.setAlignment(Align.center);
        input.setTextFieldFilter(new TextField.TextFieldFilter() {
            @Override
            public boolean acceptChar(TextField textField, char c) {
                if (c== ' '){
                return false;}
                return true;
            }
        });

        popUp.setPosition(1280/2-popUp.getWidth()/2,720/2-popUp.getHeight()/2);
        input.setPosition(1280/2-input.getWidth()/2,720/2-input.getHeight()/2);
        ok.setPosition(1280/2-ok.getWidth()/2,720/2-ok.getHeight()*2);
        stage.addActor(popUp);
        stage.addActor(input);
        stage.addActor(ok);
        Gdx.input.setInputProcessor(stage);



        ok.addListener(new ChangeListener(){
            public void changed(ChangeEvent event, Actor actor){
                changeHighscore(input.getText());
                dispose();
                game.setScreen(new MainMenuScreen(game));
            }
        });
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(100/255f, 127/255f, 127/255f, 1);
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



    void changeHighscore(String name){
        try {


            BufferedReader br = new BufferedReader(new FileReader("core/Highscore.txt"));



            String Text="";
            String finalText;
            String erster=br.readLine();
            String zweiter=br.readLine();
            int temp;
             if (Integer.parseInt(erster.split(" ")[1])<score) {
                 Text=Text+name+" "+score+"\r\n"+erster+"\r\n"+zweiter;
             }else if (Integer.parseInt(zweiter.split(" ")[1])<score) {
                Text=Text+erster+"\r\n"+name+" "+score+"\r\n"+zweiter;
             }else {
                 Text=Text+erster+"\r\n"+zweiter+"\r\n"+name+" "+score;
             }
            System.out.println(Text);
            PrintWriter pw=new PrintWriter("core/Highscore.txt");
            pw.print(Text);
            pw.flush();

        } catch (IOException e){}

        }

    }

