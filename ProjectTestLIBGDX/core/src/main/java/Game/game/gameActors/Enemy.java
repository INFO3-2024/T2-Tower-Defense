package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Enemy extends GameObject {

	private int healthPoints;
	private double velocidade;
	private int damage;

	public Enemy(int positionX, int positionY, int id) {
		// TODO Auto-generated constructor stub
		setPosition(positionX, positionY);

		switch (id) {

		case 1:
			imagem = new Texture(Gdx.files.internal("EnemyLvl1.png"));
			healthPoints = 1;
			velocidade = 1 * Gdx.graphics.getDeltaTime();
			damage = 1;
			break;
		
		case 2:
			imagem = new Texture(Gdx.files.internal("EnemyLvl2.png"));
			healthPoints = 2;
			velocidade = 1.5 * Gdx.graphics.getDeltaTime();
			damage = 2;
			break;
			
		case 3:
			imagem = new Texture(Gdx.files.internal("EnemyLvl3.png"));
			healthPoints = 4;
			velocidade = 2 * Gdx.graphics.getDeltaTime();
			damage = 3;
			break;
		
		case 4:
			imagem = new Texture(Gdx.files.internal("EnemyLvl4.png"));
			healthPoints = 6;
			velocidade = 2 * Gdx.graphics.getDeltaTime();
			damage = 4;
			break;
			
		case 5:
			imagem = new Texture(Gdx.files.internal("EnemyLvl5.png"));
			healthPoints = 10;
			velocidade = 2.5 * Gdx.graphics.getDeltaTime();
			damage = 5;
			break;
		
		default:
			imagem = new Texture(Gdx.files.internal("EnemyLvl1.png"));
			healthPoints = 1;
			velocidade = 1 * Gdx.graphics.getDeltaTime();
			damage = 1;
			break;
		}
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		move();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		batch.draw(imagem, getX(), getY(), imagem.getWidth(), imagem.getHeight());

	}
	public void move() {
		this.moveBy((float) 0.2,0);
	}

	public void doDamage() {

	}

}
