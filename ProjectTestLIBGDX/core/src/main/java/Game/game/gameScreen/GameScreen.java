package Game.game.gameScreen;

import Game.game.menuStage.MenuStage;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import Game.game.gameStage.GameStage;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen{


	private Stage stage;

	public GameScreen(){

		stage = new MenuStage(this);
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


    public void changeStage(int i) {
        switch (i){
            case 1:
                stage = new GameStage();
                break;
            case 2:
                stage = new MenuStage(this);
                break;
        }
    }
}
