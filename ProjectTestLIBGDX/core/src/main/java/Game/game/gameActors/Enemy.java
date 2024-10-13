package Game.game.gameActors;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends GameObject {

	private int coinsDropped;
	private int healthPoints;
	private double velocidade;
	private int damage;
	private int typeMap;
	private float velX = 0, velY = 0;
	private boolean alreadyDoneDamage = false;
	private int index = 0;
	private Vector2 currentPosition;
	private Vector2 nextPosition;

	private ArrayList<Vector2> waypointsMap1 = new ArrayList<Vector2>();
	private ArrayList<Vector2> waypointsMap2 = new ArrayList<Vector2>();
	private ArrayList<Vector2> waypointsMap3 = new ArrayList<Vector2>();

	public Enemy(int positionX, int positionY, int configNumber, int typeMap) {
		setWaypoints1();
		setWaypoints2();
		setWaypoints3();

		this.typeMap = typeMap;

		setPosition(positionX, positionY);

		switch (configNumber) {
		case 1:
			enemyAssets2();

			healthPoints = 5;
			velocidade = 1;
			damage = 1;
			coinsDropped = 10;
			break;

		case 2:
			imagem = new Texture(Gdx.files.internal("enemiesAssets/zombie_1.png"));

			healthPoints = 10;
			velocidade = 1;
			damage = 2;
			coinsDropped = 20;
			break;

		case 3:
			imagem = new Texture(Gdx.files.internal("enemiesAssets/zombie_1.png"));
			healthPoints = 15;
			velocidade = 1;
			damage = 3;
			coinsDropped = 30;
			break;

		case 4:
			imagem = new Texture(Gdx.files.internal("enemiesAssets/zombie_1.png"));
			healthPoints = 25;
			velocidade = 1;
			damage = 4;
			coinsDropped = 40;
			break;

		case 5:
			imagem = new Texture(Gdx.files.internal("enemiesAssets/zombie_1.png"));
			healthPoints = 40;
			velocidade = 1;
			damage = 5;
			coinsDropped = 50;
			break;

		default:
			imagem = new Texture(Gdx.files.internal("enemiesAssets/zombie_1.png"));
			healthPoints = 5;
			velocidade = 1;
			damage = 1;
			coinsDropped = 10;
			break;
		}
		// counter++;
		// id = counter;
	}

    private void setWaypoints3() {
        // TODO Auto-generated method stub

        Vector2 aux = new Vector2(165, 680);
        waypointsMap3.add(aux);
        aux = new Vector2(165, 130);
        waypointsMap3.add(aux);
        aux = new Vector2(320, 130);
        waypointsMap3.add(aux);
        aux = new Vector2(320, 710);
        waypointsMap3.add(aux);
        aux = new Vector2(455, 710);
        waypointsMap3.add(aux);
        aux = new Vector2(455, 390);
        waypointsMap3.add(aux);
        aux = new Vector2(545, 390);
        waypointsMap3.add(aux);
        aux = new Vector2(545, 205);
        waypointsMap3.add(aux);
        aux = new Vector2(705, 205);
        waypointsMap3.add(aux);
        aux = new Vector2(705, 710);
        waypointsMap3.add(aux);
        aux = new Vector2(835, 710);
        waypointsMap3.add(aux);
        aux = new Vector2(835, 100);
        waypointsMap3.add(aux);
        aux = new Vector2(995, 100);
        waypointsMap3.add(aux);
        aux = new Vector2(995, 480);
        waypointsMap3.add(aux);
        aux = new Vector2(1275, 480);
        waypointsMap3.add(aux);
    }

    private void setWaypoints2() {

        Vector2 aux = new Vector2(165, 135);
        waypointsMap2.add(aux);
        aux = new Vector2(165, 680);
        waypointsMap2.add(aux);
        aux = new Vector2(320, 680);
        waypointsMap2.add(aux);
        aux = new Vector2(320, 515);
        waypointsMap2.add(aux);
        aux = new Vector2(485, 515);
        waypointsMap2.add(aux);
        aux = new Vector2(485, 680);
        waypointsMap2.add(aux);
        aux = new Vector2(645, 680);
        waypointsMap2.add(aux);
        aux = new Vector2(645, 360);
        waypointsMap2.add(aux);
        aux = new Vector2(320, 360);
        waypointsMap2.add(aux);
        aux = new Vector2(320, 135);
        waypointsMap2.add(aux);
        aux = new Vector2(805, 135);
        waypointsMap2.add(aux);
        aux = new Vector2(805, 680);
        waypointsMap2.add(aux);
        aux = new Vector2(965, 680);
        waypointsMap2.add(aux);
        aux = new Vector2(965, 135);
        waypointsMap2.add(aux);
        aux = new Vector2(1155, 135);
        waypointsMap2.add(aux);
        aux = new Vector2(1155, 680);
        waypointsMap2.add(aux);
        aux = new Vector2(1275, 680);
        waypointsMap2.add(aux);
    }

    private void setWaypoints1() {

        // Spawn dos inimigos mapa 1 (0,615)

        Vector2 aux = new Vector2(165, 665);
        waypointsMap1.add(aux);
        aux = new Vector2(165, 95);
        waypointsMap1.add(aux);
        aux = new Vector2(260, 95);
        waypointsMap1.add(aux);
        aux = new Vector2(260, 665);
        waypointsMap1.add(aux);
        aux = new Vector2(355, 665);
        waypointsMap1.add(aux);
        aux = new Vector2(355, 95);
        waypointsMap1.add(aux);
        aux = new Vector2(575, 95);
        waypointsMap1.add(aux);
        aux = new Vector2(575, 200);
        waypointsMap1.add(aux);
        aux = new Vector2(480, 200);
        waypointsMap1.add(aux);
        aux = new Vector2(480, 665);
        waypointsMap1.add(aux);
        aux = new Vector2(770, 665);
        waypointsMap1.add(aux);
        aux = new Vector2(770, 200);
        waypointsMap1.add(aux);
        aux = new Vector2(675, 200);
        waypointsMap1.add(aux);
        aux = new Vector2(675, 95);
        waypointsMap1.add(aux);
        aux = new Vector2(900, 95);
        waypointsMap1.add(aux);
        aux = new Vector2(900, 665);
        waypointsMap1.add(aux);
        aux = new Vector2(995, 665);
        waypointsMap1.add(aux);
        aux = new Vector2(995, 145);
        waypointsMap1.add(aux);
        aux = new Vector2(1090, 95);
        waypointsMap1.add(aux);
        aux = new Vector2(1090, 665);
        waypointsMap1.add(aux);
        aux = new Vector2(1275, 665);
        waypointsMap1.add(aux);

    }

	public void act(float delta) {
		super.act(delta);
		move();
		enemyAssets2();
		elapsedTime += Gdx.graphics.getDeltaTime();
	}

	public void enemyAssets2() {
		if (index == 0) {
			imagem = new Texture("enemiesAssets/zombie_1.png");
		} else if (index == 1) {
			imagem = new Texture("setaBaixo.png");
		} else if (index == 2) {
			imagem = new Texture("enemiesAssets/zombie_1.png");
		} else if (index == 3) {
			imagem = new Texture("setaCima.png");
		} else if (index == 4) {
			imagem = new Texture("enemiesAssets/zombie_1.png");
		} else if (index == 5) {
			imagem = new Texture("setaBaixo.png");
		} else if (index == 6) {
			imagem = new Texture("enemiesAssets/zombie_1.png");
		} else if (index == 7) {
			imagem = new Texture("setaCima.png");
		} else if (index == 8) {
			imagem = new Texture("enemyLeft.png");
		} else if (index == 9) {
			imagem = new Texture("setaCima.png");
		} else if (index == 10) {
			imagem = new Texture("enemiesAssets/zombie_1.png");
		} else if (index == 11) {
			imagem = new Texture("setaBaixo.png");
		} else if (index == 12) {
			imagem = new Texture("enemyLeft.png");
		} else if (index == 13) {
			imagem = new Texture("setaBaixo.png");
		} else if (index == 14) {
			imagem = new Texture("enemiesAssets/zombie_1.png");
		} else if (index == 15) {
			imagem = new Texture("setaCima.png");
		} else if (index == 16) {
			imagem = new Texture("enemiesAssets/zombie_1.png");
		} else if (index == 17) {
			imagem = new Texture("setaBaixo.png");
		} else if (index == 18) {
			imagem = new Texture("enemiesAssets/zombie_1.png");
		} else if (index == 19) {
			imagem = new Texture("setaCima.png");
		} else if (index == 20) {
			imagem = new Texture("enemiesAssets/zombie_1.png");
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
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
		} else if (typeMap == 2) {
			moveLogic(waypointsMap2);
		} else {
			moveLogic(waypointsMap3);
		}
		setX(getX() + velX);
		setY(getY() + velY);

		System.out.println(index + ": " + getX() + " - " + getY());
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
