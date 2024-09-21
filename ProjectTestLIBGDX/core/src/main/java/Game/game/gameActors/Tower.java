package Game.game.gameActors;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public abstract class Tower extends GameObject{
	
	protected float damage;
	protected float fireRate;
	protected float elapsedTime; //Tempo decorrido
	protected ShapeRenderer range;
	protected ArrayList<Image> BulletsArray;
	
	
	public Tower() {
		elapsedTime = 0;
		fireRate = 0;
	}
	
	public abstract void shoot();

}
