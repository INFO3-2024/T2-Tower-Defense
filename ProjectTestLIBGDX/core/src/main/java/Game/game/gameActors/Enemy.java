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
	private int configNumber;

	private ArrayList<Vector2> waypointsMap1 = new ArrayList<Vector2>();
	private ArrayList<Vector2> waypointsMap2 = new ArrayList<Vector2>();
	private ArrayList<Vector2> waypointsMap3 = new ArrayList<Vector2>();

	public Enemy(int positionX, int positionY, int configNumber, int typeMap) {
		setWaypoints1();
		setWaypoints2();
		setWaypoints3();

		this.typeMap = typeMap;
		this.configNumber = configNumber;

		setPosition(positionX, positionY);

		switch (configNumber) {
		case 1:

			enemyAssets();

			healthPoints = 5;
			velocidade = 1;
			damage = 1;
			coinsDropped = 10;
			break;

		case 2:
			enemyAssets();

			healthPoints = 10;
			velocidade = 1;
			damage = 2;
			coinsDropped = 20;
			break;

		case 3:
			enemyAssets();
			healthPoints = 15;
			velocidade = 1;
			damage = 3;
			coinsDropped = 30;
			break;

		case 4:
			enemyAssets();
			healthPoints = 25;
			velocidade = 1;
			damage = 4;
			coinsDropped = 40;
			break;

		case 5:
			enemyAssets();
			healthPoints = 40;
			velocidade = 1;
			damage = 5;
			coinsDropped = 50;
			break;

		default:
			enemyAssets();
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
		enemyAssets();
		elapsedTime += Gdx.graphics.getDeltaTime();
	}
  
	public void enemyAssets(){
		if (index ==0){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/direita.png");
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/direita.png");
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/direita.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/direita.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/direita.png");
			}
		} 
		else if (index ==1){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/baixo.png");
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/baixo.png");
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/baixo.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/baixo.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/baixo.png");
			}
		} 
		else if (index == 2){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/direita.png"); 
			}else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/direita.png");
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/direita.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/direita.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/direita.png");
			}
		} 
		else if (index == 3){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/cima.png"); 
			} else if (configNumber ==2){
				imagem = new Texture("enemiesAssets/enemy2/cima.png");
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/cima.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/cima.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/cima.png");
			}
		} 
		else if (index == 4){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/direita.png"); 
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/direita.png"); 
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/direita.png"); 
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/direita.png"); 
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/direita.png"); 
			}
		} 
		else if (index == 5){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/baixo.png");
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/baixo.png");
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/baixo.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/baixo.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/baixo.png");
			}
		} 
		else if (index == 6){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/direita.png"); 
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/direita.png"); 
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/direita.png"); 
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/direita.png"); 
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/direita.png"); 
			}
		} 
		else if (index == 7){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/cima.png");
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/cima.png");
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/cima.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/cima.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/cima.png");
			}
		} 
		else if (index == 8){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/esquerda.png");
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/esquerda.png");
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/esquerda.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/esquerda.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/esquerda.png");
			}
		} 
		else if (index ==9){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/cima.png");
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/cima.png");
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/cima.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/cima.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/cima.png");
			}
		}
		else if (index ==10){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/direita.png"); 
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/direita.png"); 
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/direita.png"); 
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/direita.png"); 
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/direita.png"); 
			}
		} 
		else if (index == 11){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/baixo.png");
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/baixo.png");
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/baixo.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/baixo.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/baixo.png");
			}
		} 
		else if (index == 12){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/esquerda.png");
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/esquerda.png");
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/esquerda.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/esquerda.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/esquerda.png");
			}
		} 
		else if (index == 13){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/baixo.png");
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/baixo.png");
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/baixo.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/baixo.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/baixo.png");
			}
		} 
		else if (index == 14){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/direita.png");
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/direita.png");
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/direita.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/direita.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/direita.png");
			}
		} 
		else if (index == 15){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/cima.png");
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/cima.png");
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/cima.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/cima.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/cima.png");
			}
		} 
		else if (index == 16){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/direita.png"); 
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/direita.png"); 
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/direita.png"); 
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/direita.png"); 
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/direita.png"); 
			}
		} 
		else if (index == 17){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/baixo.png");
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/baixo.png");
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/baixo.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/baixo.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/baixo.png");
			}
		} 
		else if (index == 18){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/direita.png"); 
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/direita.png"); 
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/direita.png");
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/direita.png");
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/direita.png");
			}
		} 
		else if (index == 19){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/cima.png"); 
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/cima.png"); 
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/cima.png"); 
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/cima.png"); 
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/cima.png"); 
			}
		} 
		else if (index == 20){
			if (configNumber == 1){
				imagem = new Texture("enemiesAssets/enemy1/direita.png"); 
			} else if (configNumber == 2){
				imagem = new Texture("enemiesAssets/enemy2/direita.png"); 
			} else if (configNumber == 3){
				imagem = new Texture("enemiesAssets/enemy3/direita.png"); 
			} else if (configNumber == 4){
				imagem = new Texture("enemiesAssets/enemy4/direita.png"); 
			} else if (configNumber == 5){
				imagem = new Texture("enemiesAssets/enemy5/direita.png"); 
			}
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
		//System.out.println(index+": "+ getX() + " - " + getY());
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
