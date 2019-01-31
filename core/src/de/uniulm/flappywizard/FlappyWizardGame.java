package de.uniulm.flappywizard;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyWizardGame extends Game {

	
	public SpriteBatch batch;


	public Texture hermine;
	public Texture harry, luna, malfoy, cedrig;
	public Texture item_blau, item_gruen, item_rot, item_silber;
	public Texture dementor, turm_gryffindor, turm_huffelpuff, turm_ravenclaw, turm_slytherin;
	
	public BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		
		hermine = new Texture("core/assets/png/hermine.png");

		
		harry = new Texture("core/assets/png/harry.png");
		luna = new Texture("core/assets/png/luna.png");
		malfoy = new Texture("core/assets/png/malfoy.png");
		cedrig = new Texture("core/assets/png/cedrig.png");
		
		item_blau = new Texture("core/assets/png/item_blau.png");
		item_gruen = new Texture("core/assets/png/item_gruen.png");
		item_rot = new Texture("core/assets/png/item_rot.png");
		item_silber = new Texture("core/assets/png/item_silber.png");
		
		dementor = new Texture("core/assets/png/dementor.png");
		turm_gryffindor = new Texture("core/assets/png/turm_gryffindor.png");
		turm_huffelpuff = new Texture("core/assets/png/turm_huffelpuff.png");
		turm_ravenclaw = new Texture("core/assets/png/turm_ravenclaw.png");
		turm_slytherin = new Texture("core/assets/png/turm_slytherin.png");
		
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

		
		harry.dispose();
		luna.dispose();
		malfoy.dispose();
		cedrig.dispose();
		
		item_blau.dispose();
		item_gruen.dispose();
		item_rot.dispose();
		item_silber.dispose();
		
		dementor.dispose();
		turm_gryffindor.dispose();
		turm_huffelpuff.dispose();
		turm_ravenclaw.dispose();
		turm_slytherin.dispose();
	}
}
