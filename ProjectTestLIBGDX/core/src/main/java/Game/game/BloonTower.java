package Game.game;

import com.badlogic.gdx.*;
import Game.game.gameScreen.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class BloonTower extends Game {
   

    @Override
    public void create() {
       
    	setScreen(new GameScreen());
        
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
