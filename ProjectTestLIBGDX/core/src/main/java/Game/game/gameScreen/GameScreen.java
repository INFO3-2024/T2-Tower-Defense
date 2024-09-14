package Game.game.gameScreen;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import Game.game.gameStage.GameStage;

public class GameScreen implements Screen{
	
	
	private GameStage stage;
	
	public GameScreen(){
		
		stage = new GameStage();
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.draw();
		stage.act(delta);
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
