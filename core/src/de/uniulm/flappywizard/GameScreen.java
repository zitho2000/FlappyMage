package de.uniulm.flappywizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {

    final FlappyWizardGame game;
    final int SCROLLSPEED = 5;

    public int sizechange=0;

    OrthographicCamera camera;
    Mage mage = new Mage(200, 400);
    Dementor dementor1 = new Dementor(960, 0);
    Dementor dementor2= new Dementor(dementor1.getPosition().x+320,0);
    Dementor dementor3= new Dementor(dementor2.getPosition().x+320,0);
    Dementor dementor4= new Dementor(dementor3.getPosition().x+320,0);
    Tower tower1 = new Tower(960, 432423);
    Tower tower2 = new Tower(tower1.getPosition().x+320,0);
    Tower tower3 = new Tower(tower2.getPosition().x+320,0);
    Tower tower4 = new Tower(tower3.getPosition().x+320,0);
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


        obstacleRoutine(dementor1);
        obstacleRoutine(dementor2);
        obstacleRoutine(dementor3);
        obstacleRoutine(dementor4);
        obstacleRoutine(tower1);
        obstacleRoutine(tower2);
        obstacleRoutine(tower3);
        obstacleRoutine(tower4);
        itemRoutine(troll);
        wizardRoutine(mage);


        game.batch.begin();

        drawWizard(mage);
        drawItem(troll);
        drawObstacle(dementor1);
        drawObstacle(dementor2);
        drawObstacle(dementor3);
        drawObstacle(dementor4);
        drawObstacle(tower1);
        drawObstacle(tower2);
        drawObstacle(tower3);
        drawObstacle(tower4);

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


    void wizardRoutine(Mage wizard){
        mage.fall();
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            mage.flyUp();
        }
        if (wizard.getPosition().y <= 0) {
            mage.die();
            dispose();
            game.setScreen(new MainMenuScreen(game));

        }
        if (mage.alive== false){
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }
    }


    void obstacleRoutine(Obstacle obstacle) {
        obstacle.moveLeft(SCROLLSPEED);
        if (obstacle.hitbox.overlaps(mage.hitbox)) {
            System.out.println("hitted");
            mage.die();
        }

        if (obstacle.getPosition().x+obstacle.hitbox.width <=0){
            obstacle.setPosition(1280);
        }
    }



    void itemRoutine(Item item) {
        item.moveLeft(SCROLLSPEED);
        if (item.hitbox.overlaps(mage.hitbox)) {
            System.out.println("collected");


        }
    }



    void drawObstacle(Obstacle obstacle) {
        game.batch.draw(obstacle.texture
                , obstacle.getPosition().x
                , obstacle.getPosition().y
                , obstacle.hitbox.width
                , obstacle.hitbox.height
        );
    }

    void drawItem(Item item) {
        game.batch.draw(item.texture
                , item.getPosition().x
                , item.getPosition().y
                , item.hitbox.width
                , item.hitbox.height
        );
    }

    void drawWizard(Mage wizard){
        game.batch.draw(wizard.texture
                , wizard.getPosition().x
                , wizard.getPosition().y
                , wizard.hitbox.width
                , wizard.hitbox.height
        );

    }

}
