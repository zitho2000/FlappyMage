package de.uniulm.flappywizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameScreen implements Screen {

    public final FlappyWizardGame game;

    public double speed;
    public int gravity ;
    public float counter ;
    public int score ;
    public int smoothJump ;
    public double faster;


    OrthographicCamera camera;

    private Mage mage ;     //Spielfigur

    //obere Hindernisse
    private Dementor dementor1;
    private Dementor dementor2;
    private Dementor dementor3;
    private Dementor dementor4;

    //untere Hindernisse
    private Tower tower1;
    private Tower tower2;
    private Tower tower3;
    private Tower tower4;

    private BitmapFont scorelabel;      //Punkteanzeige

    //sammelbare Gegenstände
    private Troll troll;
    private DoublePoints doublePoints;
    private Invulnerablility invulnerablility;
    private Turbo turbo;


    public GameScreen(FlappyWizardGame game) {


        this.game = game;


        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        this.gravity = 0;
        this.counter = 10;
        this.score = 0;
        this.smoothJump = 15;
        this.faster = 0;
        this.speed = 5;


        this.mage = new Mage(200, 400);
        this.dementor1 = new Dementor(1000);
        this.dementor2 = new Dementor(dementor1.getPosition().x + 800);
        this.dementor3 = new Dementor(dementor2.getPosition().x + 800);
        this.dementor4 = new Dementor(dementor3.getPosition().x + 800);
        this.tower1 = new Tower(600);
        this.tower2 = new Tower(tower1.getPosition().x + 800);
        this.tower3 = new Tower(tower2.getPosition().x + 800);
        this.tower4 = new Tower(tower3.getPosition().x + 800);
        this.scorelabel = new BitmapFont();


        this.troll = new Troll();
        this.doublePoints = new DoublePoints();
        this.invulnerablility = new Invulnerablility();
        this.turbo = new Turbo();


        this.spawn(turbo);


    }

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub

        Gdx.gl.glClearColor(100 / 255f, 127 / 255f, 127 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        counter = counter + delta;

        if (mage.alive) {


            obstacleRoutine(dementor1);
            obstacleRoutine(dementor2);
            obstacleRoutine(dementor3);
            obstacleRoutine(dementor4);
            obstacleRoutine(tower1);
            obstacleRoutine(tower2);
            obstacleRoutine(tower3);
            obstacleRoutine(tower4);
            wizardRoutine(mage);
            itemRoutine(troll);
            itemRoutine(turbo);
            itemRoutine(invulnerablility);
            itemRoutine(doublePoints);
            itemHandling();


            game.batch.begin();


            drawObstacle(dementor1);
            drawObstacle(dementor2);
            drawObstacle(dementor3);
            drawObstacle(dementor4);
            drawObstacle(tower1);
            drawObstacle(tower2);
            drawObstacle(tower3);
            drawObstacle(tower4);
            drawWizard(mage);
            drawItem(troll);
            drawItem(invulnerablility);
            drawItem(turbo);
            drawItem(doublePoints);
            scorelabel.draw(game.batch, Integer.toString(score), 1230, 700);
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
        mage.getTexture().dispose();
        tower1.texture.dispose();
        tower2.texture.dispose();
        tower3.texture.dispose();
        tower4.texture.dispose();
        dementor1.texture.dispose();
        dementor2.texture.dispose();
        dementor3.texture.dispose();
        dementor4.texture.dispose();
        invulnerablility.getTexture().dispose();
        doublePoints.getTexture().dispose();
        turbo.getTexture().dispose();
        troll.getTexture().dispose();

    }


    void wizardRoutine(Mage wizard) {

        //y-Bewegung vom Zauberer
        mage.fall(gravity);
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            smoothJump = 0;
        }
        if (smoothJump <= 15) {
            smoothJump++;
            mage.flyUp(25 - smoothJump);
        }


        if (mage.getPosition().y + mage.getSize().y >= 720) {
            mage.setPosition(mage.getPosition().x, 720 - mage.getSize().y);
        }

        //neuer Screen-Aufruf beim Tod des Zauberers
        if (wizard.getPosition().y <= 0) {
            mage.die();
        }
        if (mage.alive == false) {
            boolean isNewHighscore = readHighscore();

            if (isNewHighscore) {

                game.setScreen(new GameOverScreen(game, score));
                dispose();
            } else {

                game.setScreen(new MainMenuScreen(game));
                dispose();
            }


        }
    }


    void obstacleRoutine(Obstacle obstacle) {
        obstacle.moveLeft(this.speed);

        //Kollision mit Zauberer
        if (obstacle.hitbox.overlaps(mage.getHitbox()) && !obstacle.hitted) {
            obstacle.hitted = true;
            if (invulnerablility.active || turbo.active) {
                invulnerablility.deactivate();
            } else {
                mage.die();
            }
        }

        //überwundene Hindernisse werden wiederverwendet
        if (obstacle.getPosition().x + obstacle.size.x <= 0) {
            obstacle.reposition();
        }

        //Größenaktualisierung bei bestimmten aktiven Items
        if (turbo.active) {
            obstacle.resize(250);
        }
        if (troll.active) {
            obstacle.resize(obstacle.size.y * 1.2f);
        }
        if(counter>5 ){
            obstacle.resizable=true;
        }

        //Zähler für score etc.
        if (mage.getPosition().x >= obstacle.getPosition().x && !obstacle.countet) {
            score++;
            faster = faster + 0.01;
            if (doublePoints.active) {
                score++;
            }
            obstacle.countet = true;
        }
    }


    void itemRoutine(Item item) {
        item.moveLeft(this.speed);

        //Kollisionsbehandlung mit Zauberer
        if (item.getHitbox().overlaps(mage.getHitbox())) {
            System.out.println("collected");
            counter = 0;
            item.activate();

        }
        if (counter <= 5) {

            if (item.getHitbox().overlaps(new Rectangle(1280, 0, 50, 720))) {
                spawn(item);
            }
        } else {
            item.deactivate();
        }

        //neues Item spawnen, wenn nicht eingesammelt
        if (item.getHitbox().overlaps(new Rectangle(-100, 0, 50, 720)) || item.getHitbox().overlaps(mage.getHitbox())) {
            item.setPosition(1000000, 1000000);
            int rng = (int) (Math.random() * 4) + 1;
            if (rng == 1) {
                spawn(troll);
            }
            if (rng == 2) {
                spawn(turbo);
            }
            if (rng == 3) {
                spawn(doublePoints);
            }
            if (rng == 4) {
                spawn(invulnerablility);
            }
        }
    }

    //spawnt ein item
    void spawn(Item item) {
        item.setPosition((float) Math.random() * 1280 + 1500, (float) Math.random() * 620 + 50);
        if (item.getHitbox().overlaps(dementor1.hitbox) || item.getHitbox().overlaps(dementor1.hitbox) || item.getHitbox().overlaps(dementor2.hitbox) || item.getHitbox().overlaps(dementor3.hitbox) || item.getHitbox().overlaps(dementor4.hitbox) || item.getHitbox().overlaps(tower1.hitbox) || item.getHitbox().overlaps(tower2.hitbox) || item.getHitbox().overlaps(tower3.hitbox) || item.getHitbox().overlaps(tower4.hitbox)) {
            spawn(item);
        }
    }


    void itemHandling() {
        speed = 5 + faster;
        gravity = 10;

        //Turbo-mode-Behandlungen
        if (turbo.active) {
            smoothJump = 15;
            speed = speed * 5;
            gravity = 0;
            mage.setPosition(mage.getPosition().x, 720 / 2 - mage.getSize().y / 2);
        }

        //Troll-Behandlungen
        if (troll.active) {
        }
        mage.setSize(100, 100);

        //Unverwundbarkeits-Behandlungen
        if (invulnerablility.active) {
            mage.setSize(50, 50);
        }
        //Doppelte-Punkte-Behandlungen
        if (doublePoints.active) {
        }
    }

    //Hindernis malen
    void drawObstacle(Obstacle obstacle) {
        game.batch.draw(obstacle.texture
                , obstacle.getPosition().x
                , obstacle.getPosition().y
                , obstacle.getSize().x
                , obstacle.getSize().y
        );
    }

    //Gegenstand malen
    void drawItem(Item item) {
        game.batch.draw(item.getTexture()
                , item.getPosition().x
                , item.getPosition().y
                , item.getSize().x
                , item.getSize().y
        );
    }

    //Zauberer malen
    void drawWizard(Mage wizard) {
        game.batch.draw(wizard.getTexture()
                , wizard.getPosition().x
                , wizard.getPosition().y
                , wizard.getSize().x
                , wizard.getSize().y
        );

    }


    //Highscore lesen und vergleichen, ob neuer Highscore erreicht wurde
    boolean readHighscore() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("core/Highscore.txt"));

            String line = "";
            String s;
            while ((s = br.readLine()) != null) {
                line += s + "\r\n";
            }

            System.out.println(line);

            int last = Integer.parseInt(line.split("\r\n")[2].split(" ")[1]);
            if (last < score) {
                return true;
            }


        } catch (IOException e) {

        }
        return false;
    }

}
