package Game.game.gameActors;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;

public abstract class Tower extends GameObject {
	
	protected bulletTipe bulletTipe;
	protected float damage;
	protected double fireRate;
	protected int shootingRange;
	protected ArrayList<Bullet> bulletsArray;
	protected float projectileSpeed;
	protected ArrayList<Enemy> enemiesInRange;
	protected float projectileActingTime;

	public Tower() {
		bulletsArray = new ArrayList<Bullet>();
		enemiesInRange = new ArrayList<Enemy>();
	}

	public ArrayList<Bullet> tryToShoot(Array<Actor> listaAtores) {
		
		checkEnemiesInRange(listaAtores);
		
		Vector2 positionToGo = getFarthestEnemyPosition();
		
		elapsedTime += Gdx.graphics.getDeltaTime();

		if (!enemiesInRange.isEmpty() && elapsedTime >= fireRate) {

			elapsedTime = 0;
			
			bulletsArray.add(new Bullet(this.getX(), this.getY(), positionToGo.x, positionToGo.y, projectileSpeed, damage, bulletTipe));
		}
		
		return bulletsArray;

	}

	// get para pegar o inimigo mais perto do final que ainda esteja na range da
	// torre
	private Vector2 getFarthestEnemyPosition() {

		float farthestDistance = 0;
		
		float positionX = 0;
		float positionY = 0;
		
		Vector2 position;
		
		if(!enemiesInRange.isEmpty()) {
			for (int i = 0; i < enemiesInRange.size(); i++) {
				if (enemiesInRange.get(i).getX() > farthestDistance) {
					farthestDistance = enemiesInRange.get(i).getX();
					positionX = enemiesInRange.get(i).getX();
					positionY = enemiesInRange.get(i).getY();
				}
			}
		}
		position = new Vector2(positionX, positionY);


		return position;
	}

	public void checkEnemiesInRange(Array<Actor> listaAtores) {

		// algoritmo para inserir inimigos que estão dentro do alcance da torre no array
		// enemiesInRange
		for (int i = 0; i < listaAtores.size; i++) {
			if (listaAtores.get(i) instanceof Enemy) {

				Enemy enemyAux = (Enemy) listaAtores.get(i);

				if (calculateDistance(enemyAux) <= shootingRange) {
					enemiesInRange.add(enemyAux);
				}
			}
		}

		// retirando do array inimigos fora do alcance da torre
		if(!enemiesInRange.isEmpty()) {
			for (int i = 0; i < enemiesInRange.size(); i++) {
				if (calculateDistance(enemiesInRange.get(i)) > shootingRange || enemiesInRange.get(i).getHealthPoints() <= 0) {
					enemiesInRange.remove(i);
				}
			}
		}
	}

	public float calculateDistance(GameObject otherObject) {
		float distance = (float) Math.sqrt(
				Math.pow((otherObject.getX() - this.getX()), 2) + Math.pow((otherObject.getY() - this.getY()), 2));
		return distance;
	}
}
