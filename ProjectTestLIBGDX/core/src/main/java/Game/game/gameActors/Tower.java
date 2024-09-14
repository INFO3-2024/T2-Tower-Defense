package Game.game.gameActors;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public abstract class Tower extends GameObject{
	
	private float fireRate;
	private ShapeRenderer range;
	
	public Tower() {
	}
	
	public abstract void shoot();

}
