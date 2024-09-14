package Game.game.gameActors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class GameObject extends Actor{
	
	protected Texture imagem;
	protected Rectangle hitbox;
	
	public GameObject() {

	}

}
