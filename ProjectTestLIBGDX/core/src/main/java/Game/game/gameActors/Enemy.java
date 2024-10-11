package Game.game.gameActors;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends GameObject {

	private int coinsDropped;
	private int healthPoints;
	private double velocidade;
	private int damage;
	private int typeMap;
	private float velX = 0, velY = 0;
	// private static int counter = 0;
	// private int id;
	private boolean alreadyDoneDamage = false;

	private int index = 0;

	private ArrayList<Vector2> waypointsMap1 = new ArrayList<Vector2>();
	private ArrayList<Vector2> waypointsMap2 = new ArrayList<Vector2>();

	public Enemy(int positionX, int positionY, int configNumber, int typeMap) {
		// TODO Auto-generated constructor stub

		setWaypoints1();
		setWaypoints2();
		
		this.typeMap = typeMap;

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
			velocidade = 1;
			damage = 2;
			coinsDropped = 2;
			break;

		case 3:
			imagem = new Texture(Gdx.files.internal("EnemyLvl3.png"));
			healthPoints = 15;
			velocidade = 1;
			damage = 3;
			coinsDropped = 3;
			break;

		case 4:
			imagem = new Texture(Gdx.files.internal("EnemyLvl4.png"));
			healthPoints = 25;
			velocidade = 1;
			damage = 4;
			coinsDropped = 4;
			break;

		case 5:
			imagem = new Texture(Gdx.files.internal("EnemyLvl5.png"));
			healthPoints = 40;
			velocidade = 1;
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
		// counter++;
		// id = counter;
	}

	private void setWaypoints2() {

		Vector2 aux = new Vector2(170, 105);
		waypointsMap2.add(aux);
		aux = new Vector2(170, 650);
		waypointsMap2.add(aux);
		aux = new Vector2(325, 650);
		waypointsMap2.add(aux);
		aux = new Vector2(325, 485);
		waypointsMap2.add(aux);
		aux = new Vector2(490, 485);
		waypointsMap2.add(aux);
		aux = new Vector2(490, 650);
		waypointsMap2.add(aux);
		aux = new Vector2(650, 650);
		waypointsMap2.add(aux);
		aux = new Vector2(650, 330);
		waypointsMap2.add(aux);
		aux = new Vector2(325, 330);
		waypointsMap2.add(aux);
		aux = new Vector2(325, 105);
		waypointsMap2.add(aux);
		aux = new Vector2(810, 105);
		waypointsMap2.add(aux);
		aux = new Vector2(810, 650);
		waypointsMap2.add(aux);
		aux = new Vector2(970, 650);
		waypointsMap2.add(aux);
		aux = new Vector2(970, 105);
		waypointsMap2.add(aux);
		aux = new Vector2(1160, 105);
		waypointsMap2.add(aux);
		aux = new Vector2(1160, 650);
		waypointsMap2.add(aux);
		aux = new Vector2(1280, 650);
		waypointsMap2.add(aux);
	}

	private void setWaypoints1() {

		// Spawn dos inimigos mapa 1 (0,615)

		Vector2 aux = new Vector2(170, 615);
		waypointsMap1.add(aux);
		aux = new Vector2(170, 75);
		waypointsMap1.add(aux);
		aux = new Vector2(265, 75);
		waypointsMap1.add(aux);
		aux = new Vector2(265, 615);
		waypointsMap1.add(aux);
		aux = new Vector2(360, 615);
		waypointsMap1.add(aux);
		aux = new Vector2(360, 75);
		waypointsMap1.add(aux);
		aux = new Vector2(580, 75);
		waypointsMap1.add(aux);
		aux = new Vector2(580, 170);
		waypointsMap1.add(aux);
		aux = new Vector2(485, 170);
		waypointsMap1.add(aux);
		aux = new Vector2(485, 615);
		waypointsMap1.add(aux);
		aux = new Vector2(775, 615);
		waypointsMap1.add(aux);
		aux = new Vector2(775, 170);
		waypointsMap1.add(aux);
		aux = new Vector2(680, 170);
		waypointsMap1.add(aux);
		aux = new Vector2(680, 75);
		waypointsMap1.add(aux);
		aux = new Vector2(905, 75);
		waypointsMap1.add(aux);
		aux = new Vector2(905, 615);
		waypointsMap1.add(aux);
		aux = new Vector2(1000, 615);
		waypointsMap1.add(aux);
		aux = new Vector2(1000, 75);
		waypointsMap1.add(aux);
		aux = new Vector2(1095, 75);
		waypointsMap1.add(aux);
		aux = new Vector2(1095, 615);
		waypointsMap1.add(aux);
		aux = new Vector2(1280, 615);
		waypointsMap1.add(aux);

	}

	public void act(float delta) {
		super.act(delta);
		move();
		elapsedTime += Gdx.graphics.getDeltaTime();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if (healthPoints > 0) {
			batch.draw(imagem, getX(), getY(), imagem.getWidth(), imagem.getHeight());
		}

	}

	private void moveLogic(ArrayList<Vector2> waypoints) {

		if (getX() != waypoints.get(index).x || getY() != waypoints.get(index).y) {

			if (getX() < waypoints.get(index).x) {
				velX = (float) velocidade;
			} else if (getX() > waypoints.get(index).x) {
				velX = (float) velocidade * -1;
			} else {
				velX = 0;
			}

			if (getY() < waypoints.get(index).y) {
				velY = (float) velocidade;
			} else if (getY() > waypoints.get(index).y) {
				velY = (float) velocidade * -1;
			} else {
				velY = 0;
			}
		} else {
			if (index != waypoints.size() - 1)
				index++;
		}
	}

	private void move() {

		if (typeMap == 1) {
			moveLogic(waypointsMap1);
		} else {
			moveLogic(waypointsMap2);
		}
		setX(getX() + velX);
		setY(getY() + velY);
		// System.out.println(getX() + " - " + getY());
	}

	private void doDamage() {

	}

	public void receiveDamage(float damageReceived) {

		if (elapsedTime > 1) {
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

	public int getCoinsDropped() {
		return coinsDropped;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	/*
	 * public int getId() { return id; }
	 */
	public int getDamage() {
		return damage;
	}
	/*
	 * @Override public String toString() { return "Enemy [id=" + id + "]"; }
	 * 
	 */

	public int getTypeMap() {
		return typeMap;
	}

	public void setTypeMap(int typeMap) {
		this.typeMap = typeMap;
	}
}
