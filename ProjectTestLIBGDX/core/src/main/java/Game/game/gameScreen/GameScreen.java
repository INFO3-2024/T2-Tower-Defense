package Game.game.gameScreen;

import Game.game.menuStage.MenuStage;
import Game.game.settingsStage.SettingsStage;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import Game.game.gameStage.GameStage;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen {
    private Stage stage;

    private int volume = 50;
    
    public GameScreen() {
        stage = new MenuStage(this);
        
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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
    	stage.dispose();

    }

    public void changeStage(int i) {
        switch (i) {
            case 0:
            	stage.clear();
                stage = new GameStage(volume);
                break;
            case 1:
            	stage.clear();
                stage = new MenuStage(this);
                break;
            case 2:
            	stage.clear();
                stage = new SettingsStage(this);
                break;
        }
    }

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
}
