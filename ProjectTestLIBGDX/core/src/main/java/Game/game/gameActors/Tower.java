package Game.game.gameActors;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;

public abstract class Tower extends GameObject {

	protected float damage;
	protected double fireRate;
	protected int shootingRange;
	protected ArrayList<Image> BulletsArray;
	protected ArrayList<Enemy> enemiesInRange;

	public Tower() {

		enemiesInRange = new ArrayList<Enemy>();
	}

	public void tryToShoot(Array<Actor> listaAtores) {
		
		seekEnemiesInRange(listaAtores);

		elapsedTime += Gdx.graphics.getDeltaTime();

		if (!enemiesInRange.isEmpty() && elapsedTime >= fireRate) {

			elapsedTime = 0;
			System.out.println(getFarthestEnemyInRangeId());

		}

	}

	// get para pegar o inimigo mais perto do final que ainda esteja na range da
	// torre
	private int getFarthestEnemyInRangeId() {

		int farthestEnemyId = 0;
		float farthestDistance = 0;
		
		if(!enemiesInRange.isEmpty()) {
			for (int i = 0; i < enemiesInRange.size(); i++) {
				if (enemiesInRange.get(i).getX() > farthestDistance) {
					farthestDistance = enemiesInRange.get(i).getX();
					farthestEnemyId = enemiesInRange.get(i).getId();
				}
			}
		}


		return farthestEnemyId;
	}

	public void seekEnemiesInRange(Array<Actor> listaAtores) {

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
				if (calculateDistance(enemiesInRange.get(i)) > shootingRange) {
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
