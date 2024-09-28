package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Bullet extends GameObject {

	float initialPositionX;
	float initialPositionY;
	float positionXToGo;
	float positionYToGo;
	float velocidade;
	float damage;
	boolean collided;
	Vector2 lastPosition;
	final static float actingTime = 3;

	public Bullet(float positionX, float positionY, float positionXToGo, float positionYToGo, float bulletSpeed,
			float damage) {

		initialPositionX = positionX;
		initialPositionY = positionY;
		this.positionXToGo = positionXToGo;
		this.positionYToGo = positionYToGo;
		setPosition(initialPositionX, initialPositionY);
		velocidade = bulletSpeed;
		this.damage = damage;
		collided = false;
		lastPosition = new Vector2();

		this.imagem = new Texture(Gdx.files.internal("Bullet.png"));

	}

	@Override
	public void act(float delta) {
		super.act(delta);
		move();
		checkCollision();// colisao bala com inimigo
		elapsedTime += Gdx.graphics.getDeltaTime();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {

		if (elapsedTime <= 3 && checkCollision() == false && lastPosition.x != getX() && lastPosition.y != getY()) {
			batch.draw(imagem, getX(), getY(), imagem.getWidth(), imagem.getHeight());
		}

	}

	private void move() {

		// movimento vetorial da bala
		Vector2 position = new Vector2(getX(), getY());
		lastPosition.set(position);
		Vector2 targetPosition = new Vector2(positionXToGo, positionYToGo);

		Vector2 direction = targetPosition.sub(position);

		if (direction.len() > 0) {
			direction.nor();
		}

		Vector2 deslocamento = direction.scl(velocidade * 10 * Gdx.graphics.getDeltaTime());

		setPosition(getX() + deslocamento.x, getY() + deslocamento.y);

	}

	public boolean checkCollision() {

		if (collided == false) {
			// para percorrer os atores da cena
			for (int i = 0; i < getStage().getActors().size; i++) {
				// verifica se o ator é do tipo inimigo
				if (getStage().getActors().get(i) instanceof Enemy) {
					Enemy enemy = (Enemy) getStage().getActors().get(i);

					// calcula a distancia do inimigo com a largura da imagem da bala e se colidir
					// aplica o dano
					if (calculateDistance(enemy) < imagem.getWidth()) {
						enemy.receiveDamage(damage);
						collided = true;
					}
				}
			}
		}
		return collided;
	}

	public float calculateDistance(GameObject otherObject) {
		float distance = (float) Math.sqrt(
				Math.pow((otherObject.getX() - this.getX()), 2) + Math.pow((otherObject.getY() - this.getY()), 2));
		return distance;
	}

	public float getElapsedTime() {
		return elapsedTime;
	}

	public float getActingTime() {
		return actingTime;
	}

}
