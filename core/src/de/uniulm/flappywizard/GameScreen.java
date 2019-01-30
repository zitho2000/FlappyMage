package de.uniulm.flappywizard;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameScreen implements Screen {

    public final FlappyWizardGame game;

    public int speed;
    public int gravity=0;

    public float counter=10;
    public int score=0;
    public int smoothJump=10;



    OrthographicCamera camera;
    Mage mage = new Mage(200, 400);
    Dementor dementor1 = new Dementor(1000);
    Dementor dementor2= new Dementor(dementor1.getPosition().x+800);
    Dementor dementor3= new Dementor(dementor2.getPosition().x+800);
    Dementor dementor4= new Dementor(dementor3.getPosition().x+800);
    Tower tower1 = new Tower(600);
    Tower tower2 = new Tower(tower1.getPosition().x+800);
    Tower tower3 = new Tower(tower2.getPosition().x+800);
    Tower tower4 = new Tower(tower3.getPosition().x+800);
     BitmapFont scorelabel=new BitmapFont();


    Troll troll = new Troll();
    DoublePoints doublePoints=new DoublePoints();
    Invulnerablility invulnerablility= new Invulnerablility();
    Turbo turbo= new Turbo();



    public GameScreen(FlappyWizardGame game) {
        this.game = game;
        this.speed=5;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        this.spawn(turbo);


    }

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub

        Gdx.gl.glClearColor(100/255f, 127/255f, 127/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        counter=counter+delta;

        if (mage.alive) {
            obstacleRoutine(dementor1);
            obstacleRoutine(dementor2);
            obstacleRoutine(dementor3);
            obstacleRoutine(dementor4);
            obstacleRoutine(tower1);
            obstacleRoutine(tower2);
            obstacleRoutine(tower3);
            obstacleRoutine(tower4);
            itemRoutine(troll);
            itemRoutine(turbo);
            itemRoutine(invulnerablility);
            itemRoutine(doublePoints);
            wizardRoutine(mage);

            itemHandling();
            System.out.println(speed);

            game.batch.begin();

            drawWizard(mage);

            drawObstacle(dementor1);
            drawObstacle(dementor2);
            drawObstacle(dementor3);
            drawObstacle(dementor4);
            drawObstacle(tower1);
            drawObstacle(tower2);
            drawObstacle(tower3);
            drawObstacle(tower4);
            drawItem(troll);
            drawItem(invulnerablility);
            drawItem(turbo);
            drawItem(doublePoints);
            scorelabel.draw(game.batch,Integer.toString(score),1230,700);
            game.batch.end();
        }
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
        mage.texture.dispose();
        tower1.texture.dispose();
        tower2.texture.dispose();
        tower3.texture.dispose();
        tower4.texture.dispose();
        dementor1.texture.dispose();
        dementor2.texture.dispose();
        dementor3.texture.dispose();
        dementor4.texture.dispose();

    }


    void wizardRoutine(Mage wizard){
        mage.fall(gravity);
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            smoothJump=0;
        }
        if (smoothJump<=15){
            smoothJump++;
            mage.flyUp(25-smoothJump);
        }



        if (wizard.getPosition().y <= 0) {
            mage.die();
        }
        if (mage.alive== false){
            boolean isNewHighscore=readHighscore();

            if(isNewHighscore) {

            }
            else {
                dispose();
                game.setScreen(new MainMenuScreen(game));
            }


        }
    }


    void obstacleRoutine(Obstacle obstacle) {
        obstacle.moveLeft(this.speed);
        if (obstacle.hitbox.overlaps(mage.hitbox)&&!obstacle.hitted) {
            obstacle.hitted=true;
            if(invulnerablility.active){
                invulnerablility.deactivate();
            }
            else {System.out.println("hitted");
            mage.die();
                }
        }

        if (obstacle.getPosition().x+obstacle.size.x <=0){
            obstacle.reposition();

        }

        if(turbo.active){
            obstacle.resize(250);
        }
        if (troll.active){
            obstacle.resize(obstacle.size.y*1.2f);
        }
        if (mage.getPosition().x>=obstacle.getPosition().x&&!obstacle.countet){
            score++;

            if (doublePoints.active){
                score++;

            }
            obstacle.countet=true;

        }
    }



    void itemRoutine(Item item) {
        item.moveLeft(this.speed);
        if (item.hitbox.overlaps(mage.hitbox)) {
            System.out.println("collected");
            counter=0;
            item.activate();

        }
        if (counter <= 5){
           // System.out.println("active");
            if (item.hitbox.overlaps(new Rectangle(1280,0,50,720))){
                spawn(item);
            }
        }else{

            item.deactivate();

        }

        if (item.hitbox.overlaps(new Rectangle(-100,0,50,720)) || item.hitbox.overlaps(mage.hitbox)){
            item.setPosition(1000000,1000000);
            int rng= (int) (Math.random()*4)+1;
            if (rng == 1){
                spawn(troll);
            }
            if (rng == 2){
                spawn(turbo);
            }
            if (rng == 3){
                spawn(doublePoints);
            }
            if (rng == 4){
                spawn(invulnerablility);
            }
        }
    }

    void spawn(Item item){
        item.setPosition((float)Math.random()*1280+1280,(float)Math.random()*620+50);
        if (item.hitbox.overlaps(dementor1.hitbox)||item.hitbox.overlaps(dementor1.hitbox)||item.hitbox.overlaps(dementor2.hitbox)||item.hitbox.overlaps(dementor3.hitbox)||item.hitbox.overlaps(dementor4.hitbox)||item.hitbox.overlaps(tower1.hitbox)||item.hitbox.overlaps(tower2.hitbox)||item.hitbox.overlaps(tower3.hitbox)||item.hitbox.overlaps(tower4.hitbox)){
            spawn(item);
        }
    }


    void itemHandling(){
        speed=5;
        gravity=10;
        if (turbo.active){
            speed=speed*5;
            gravity = 0;
            mage.setPosition(mage.getPosition().x,720/2-mage.getSize().y/2);
            mage.texture=new Texture("core/assets/png/Rakete.png");
        }
        if (troll.active){

        }
        mage.setSize(100,100);
        if (invulnerablility.active){
            mage.setSize(50,50);
        }
        if (doublePoints.active){

        }


    }




    void drawObstacle(Obstacle obstacle) {
        game.batch.draw(obstacle.texture
                , obstacle.getPosition().x
                , obstacle.getPosition().y
                , obstacle.getSize().x
                , obstacle.getSize().y
        );
    }


    void drawItem(Item item) {
        game.batch.draw(item.texture
                , item.getPosition().x
                , item.getPosition().y
                , item.getSize().x
                , item.getSize().y
        );
    }

    void drawWizard(Mage wizard){
        game.batch.draw(wizard.texture
                , wizard.getPosition().x
                , wizard.getPosition().y
                , wizard.getSize().x
                , wizard.getSize().y
        );

    }

    boolean readHighscore(){
        try{
        BufferedReader br =new BufferedReader(new FileReader("core/Highscore.txt"));

        String line="";
        String s;
        while((s =br.readLine())!=null){
            line+=s + "\r\n";
        }

            System.out.println(line);

        int last =Integer.parseInt( line.split("\r\n")[2].split(" ")[1]);
        if (last<score){
            return true;
        }


        } catch(IOException e){

        }
        return false;
    }

}
