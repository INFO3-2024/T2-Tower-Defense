package Game.game;

import com.badlogic.gdx.*;
import Game.game.gameScreen.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class TowerDefense extends Game {

    public GameScreen screen;

    @Override
    public void create() {

        screen = new GameScreen();
    	setScreen(screen);

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
       super.dispose();
    }
}
