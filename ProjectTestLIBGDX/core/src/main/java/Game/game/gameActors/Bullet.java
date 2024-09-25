package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends GameObject{
	
	
	float initialPositionX;
	float initialPositionY;
	float positionXToGo;
	float positionYToGo;
	float velocidade;
	
	public Bullet(float positionX, float positionY, float positionXToGo, float positionYToGo, float bulletSpeed) {
		
		initialPositionX = positionX;
		initialPositionY = positionY;
		this.positionXToGo = positionXToGo;
		this.positionYToGo = positionYToGo;
		setPosition(initialPositionX, initialPositionY);
		velocidade = bulletSpeed;
		
		this.imagem = new Texture(Gdx.files.internal("Bullet.png"));
		
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		move();
		elapsedTime += Gdx.graphics.getDeltaTime();
		System.out.println(elapsedTime);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		
		if(elapsedTime <= 20) {
			batch.draw(imagem, getX(), getY(), imagem.getWidth(), imagem.getHeight());
		}

	}
	
	private void move() {
		
		
		Vector2 position = new Vector2(getX(), getY());
		Vector2 targetPosition = new Vector2(positionXToGo, positionYToGo);
		
		Vector2 direction = targetPosition.sub(position);
		
		if(direction.len() > 0) {
			direction.nor();
		}
		//displacemente significa deslocamento
		Vector2 deslocamento = direction.scl(velocidade *10* Gdx.graphics.getDeltaTime());
		
		setPosition(getX() + deslocamento.x, getY() + deslocamento.y);
		
		
	}
	
}
