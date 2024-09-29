package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Enemy extends GameObject {
	
	private int coinsDropped;
	private int healthPoints;
	private double velocidade;
	private int damage;
	//private static int counter = 0;
	//private int id;
	private boolean alreadyDoneDamage = false;

	
	public Enemy(int positionX, int positionY, int configNumber) {
		// TODO Auto-generated constructor stub
		setPosition(positionX, positionY);

		switch (configNumber) {

		case 1:
			imagem = new Texture(Gdx.files.internal("EnemyLvl1.png"));
			healthPoints = 5;
			velocidade = 1; 
			damage = 1;
			coinsDropped = 1;
			break;
		
		case 2:
			imagem = new Texture(Gdx.files.internal("EnemyLvl2.png"));
			healthPoints = 10;
			velocidade = 1.2;
			damage = 2;
			coinsDropped = 2;
			break;
			
		case 3:
			imagem = new Texture(Gdx.files.internal("EnemyLvl3.png"));
			healthPoints = 15;
			velocidade = 1.5;
			damage = 3;
			coinsDropped = 3;
			break;
		
		case 4:
			imagem = new Texture(Gdx.files.internal("EnemyLvl4.png"));
			healthPoints = 25;
			velocidade = 1.5;
			damage = 4;
			coinsDropped = 4;
			break;
			
		case 5:
			imagem = new Texture(Gdx.files.internal("EnemyLvl5.png"));
			healthPoints = 40;
			velocidade = 2;
			damage = 5;
			coinsDropped = 5;
			break;
		
		default:
			imagem = new Texture(Gdx.files.internal("EnemyLvl1.png"));
			healthPoints = 5;
			velocidade = 1;
			damage = 1;
			coinsDropped = 1;
			break;
		}
		//counter++;
		//id = counter;
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		move();
		elapsedTime += Gdx.graphics.getDeltaTime();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(healthPoints > 0) {
			batch.draw(imagem, getX(), getY(), imagem.getWidth(), imagem.getHeight());
		}

	}
	private void move() {
		this.moveBy((float) velocidade /5,0);
	}

	private void doDamage() {

	}
	
	public void receiveDamage(float damageReceived) {
		
		if(elapsedTime > 1) {
			healthPoints = (int) (healthPoints - damageReceived);
			elapsedTime = 0;
		}
	}
	
	public boolean getAlreadyDoneDamage() {
        return alreadyDoneDamage;
    }
	
	public void setAlreadyDoneDamage(boolean alreadyDoneDamage) {
		this.alreadyDoneDamage = alreadyDoneDamage;
	}
	public int getCoinsDropped(){
		return coinsDropped;
	}
	
	public int getHealthPoints() {
		return healthPoints;
	}
	/*
	public int getId() {
		return id;
	}
*/
	public int getDamage() {
		return damage;
	}
	/*
	@Override
	public String toString() {
		return "Enemy [id=" + id + "]";
	}
	
*/
}
