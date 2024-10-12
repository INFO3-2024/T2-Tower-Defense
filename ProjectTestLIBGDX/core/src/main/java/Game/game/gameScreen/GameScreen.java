package Game.game.gameScreen;

import Game.game.gameMenu.MainMenu;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import Game.game.gameStage.GameStage;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen{


	private Stage currentStage;


	public GameScreen(){
        currentStage = new MainMenu();
	}

    public void changeStage(int stageIndex){
        switch (stageIndex){
            case 0:
                currentStage = new MainMenu();
                break;
            case 1:
                currentStage = new GameStage();
                break;
        }
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

        currentStage.draw();
        currentStage.act(delta);
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
