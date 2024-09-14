package Game.game.gameStage;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.scenes.scene2d.*;

import Game.game.gameActors.*;

public class GameStage extends Stage {

	private OrthographicCamera ortho;
	private Background background;
	
	public GameStage() {
		// TODO Auto-generated constructor stub
		super();
		ortho = new OrthographicCamera();
		ortho.setToOrtho(false,640,480);
		background = new Background(ortho);
		this.addActor(background);
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		
		background.act(delta);

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();
		

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		
	

	}


}
