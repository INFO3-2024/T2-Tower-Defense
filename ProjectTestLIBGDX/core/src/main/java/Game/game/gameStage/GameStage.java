package Game.game.gameStage;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.*;

import Game.game.gameActors.*;

public class GameStage extends Stage {

	private OrthographicCamera ortho;
	private Background background;

	private int playerHealthPoints;
	private int playerCoins;

	private BitmapFont font;
	private SpriteBatch batch;

	private int round;
	private float counterRoundCooldown = 0;
	private static final float roundCooldown = 5;
	private float counterSpawnCooldown = 0;
	private ArrayList<Double> spawnCooldowns;
	private int enemiesInThisRound;

	public GameStage() {
		// TODO Auto-generated constructor stub
		super();

		ortho = new OrthographicCamera();
		ortho.setToOrtho(false, 640, 480);
		background = new Background(ortho);
		this.addActor(background);

		playerHealthPoints = 100; // definicao da quantidade de vidas do jogador
		playerCoins = 0;

		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().setScale(3.5f, 3.5f);
		batch = new SpriteBatch();

		round = 5;
		enemiesInThisRound = 0;

		// a sequencia aqui e importante, pois o primeiro add vai pra primeira rodada
		// o segundo add pra segunda rodada e assim por diante
		spawnCooldowns = new ArrayList<Double>();
		spawnCooldowns.add((double) 1);
		spawnCooldowns.add((double) 1);
		spawnCooldowns.add((double) 0.5);
		spawnCooldowns.add((double) 0.8);
		spawnCooldowns.add((double) 1);
		spawnCooldowns.add((double) 1);
		spawnCooldowns.add((double) 1);
		spawnCooldowns.add((double) 1);
		spawnCooldowns.add((double) 1);
		spawnCooldowns.add((double) 1);
		
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);

		background.act(delta);

		counterSpawnCooldown += Gdx.graphics.getDeltaTime();
		counterRoundCooldown += Gdx.graphics.getDeltaTime();

		spawnEnemies();

		// Spawn de torres
		// forma temporaria de spawnar ate a juncao
		if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
			this.addActor(new SMGTower(390, 100));
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.T)) {
			this.addActor(new TrapTower(410, 100));
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.B)) {
			this.addActor(new BomberTower(430, 100));
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
			this.addActor(new SniperTower(450, 100));
		}

		// loop percorrendo todos os Atores do GameStage
		// este loop trata todos os eventos
		for (int i = 0; i < this.getActors().size; i++) {

			// Act de todos os GameObjects
			if (this.getActors().get(i) instanceof GameObject) {
				this.getActors().get(i).act(delta);
			}
		}
		towersShoot();
		enemyAttack();
		deleteBullets();
		deleteEnemies();

	}

	public int enemiesAlive() {
		int counter = 0;
		for (int i = 0; i < getActors().size; i++) {
			if (getActors().get(i) instanceof Enemy) {
				counter++;
			}
		}
		return counter;
	}

	public void deleteBullets() {
		for (int i = 0; i < this.getActors().size; i++) {
			if (getActors().get(i) instanceof Bullet) {
				Bullet bulletAux = (Bullet) getActors().get(i);
				if (bulletAux.checkCollision() || bulletAux.getElapsedTime() > bulletAux.getActingTime()) {
					getActors().removeIndex(i);
				}
			}
		}
	}

	public void deleteEnemies() {
		for (int i = 0; i < getActors().size; i++) {
			if (getActors().get(i) instanceof Enemy) {
				Enemy enemyAux = (Enemy) getActors().get(i);
				if (enemyAux.getHealthPoints() <= 0) {
					playerCoins = playerCoins + enemyAux.getCoinsDropped();
					getActors().removeIndex(i);
				}
			}
		}
	}

	// torres atirando
	// isso posteriormente sera feito usando polimorfismo
	// ainda nao esta pq preciso do mapa com os caminhos para
	// programar a traptower
	public void towersShoot() {
		for (int i = 0; i < getActors().size; i++) {
			if (this.getActors().get(i) instanceof SMGTower) {

				SMGTower towerAux = (SMGTower) this.getActors().get(i);

				if (!towerAux.tryToShoot(getActors()).isEmpty()) {
					ArrayList<Bullet> arrayAux = towerAux.tryToShoot(getActors());

					for (int j = 0; j < arrayAux.size(); j++) {
						this.addActor(arrayAux.get(j));
					}
				}
			}

			if (this.getActors().get(i) instanceof SniperTower) {

				SniperTower towerAux = (SniperTower) this.getActors().get(i);

				if (!towerAux.tryToShoot(getActors()).isEmpty()) {
					ArrayList<Bullet> arrayAux = towerAux.tryToShoot(getActors());

					for (int j = 0; j < arrayAux.size(); j++) {
						this.addActor(arrayAux.get(j));
					}
				}
			}

			if (this.getActors().get(i) instanceof BomberTower) {

				BomberTower towerAux = (BomberTower) this.getActors().get(i);

				if (!towerAux.tryToShoot(getActors()).isEmpty()) {
					ArrayList<Bullet> arrayAux = towerAux.tryToShoot(getActors());

					for (int j = 0; j < arrayAux.size(); j++) {
						this.addActor(arrayAux.get(j));
					}
				}
			}
		}
	}

	// teste para ver se o inimigo saiu da tela
	// e caso sim, diminuir as vidas do jogador
	// com base no tipo de inimigo
	public void enemyAttack() {
		for (int i = 0; i < getActors().size; i++) {
			if (this.getActors().get(i) instanceof Enemy) {

				// se o inimigo tiver saido da tela e se ele nao tiver dado dano ainda ao
				// jogador
				if (this.getActors().get(i).getX() > 639 && !((Enemy) this.getActors().get(i)).getAlreadyDoneDamage()) {

					if (((Enemy) this.getActors().get(i)).getHealthPoints() > 0) {

						int damageEnemy = ((Enemy) this.getActors().get(i)).getDamage();
						playerHealthPoints = playerHealthPoints - damageEnemy;
						((Enemy) this.getActors().get(i)).setAlreadyDoneDamage(true); // define que o inimigo em i já
																						// deu dano no jogador
					}
				}
			}
		}
	}

	public double getRoundSpawnCooldown(int rodada) {
		return spawnCooldowns.get(rodada - 1);
	}

	// por enquanto estou considerando apenas 1 mapa
	public void spawnEnemies() {
		switch (round) {

		case 1:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= getRoundSpawnCooldown(round)
					&& enemiesInThisRound < 10) {

				this.addActor(new Enemy(0, 150, 1));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 10 && enemiesAlive() == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 2:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= getRoundSpawnCooldown(round)
					&& enemiesInThisRound < 10) {

				if (enemiesInThisRound % 2 == 0) {
					this.addActor(new Enemy(0, 150, 1));
				} else {
					this.addActor(new Enemy(0, 150, 2));
				}
				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 10 && enemiesAlive() == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 3:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= getRoundSpawnCooldown(round)
					&& enemiesInThisRound < 15) {

				if (enemiesInThisRound <= 7) {
					this.addActor(new Enemy(0, 150, 1));
				} else {
					this.addActor(new Enemy(0, 150, 2));
				}

				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 15 && enemiesAlive() == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 4:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= getRoundSpawnCooldown(round)
					&& enemiesInThisRound < 20) {

				if (enemiesInThisRound % 3 == 2) { // 3
					this.addActor(new Enemy(0, 150, 1));
				} else if (enemiesInThisRound % 3 == 1) { // 1
					this.addActor(new Enemy(0, 150, 2));
				} else {
					this.addActor(new Enemy(0, 150, 3)); // 2
				}

				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 20 && enemiesAlive() == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		// uma grande horda de zumbis se aproxima
		case 5:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= getRoundSpawnCooldown(round)
					&& enemiesInThisRound < 50) {

				if (enemiesInThisRound < 20) {
					this.addActor(new Enemy(0, 150, 1));
				} else if (enemiesInThisRound >= 20 && enemiesInThisRound < 35) {
					this.addActor(new Enemy(0, 150, 2));
				} else if (enemiesInThisRound >= 35) {
					this.addActor(new Enemy(0, 150, 3));
				}

				enemiesInThisRound++;
				System.out.println(enemiesInThisRound);
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 50 && enemiesAlive() == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 6:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= getRoundSpawnCooldown(round)
					&& enemiesInThisRound < 25) {

				if (enemiesInThisRound <= 10) {
					this.addActor(new Enemy(0, 150, 2));
				} else {
					this.addActor(new Enemy(0, 150, 3));
				}

				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 25 && enemiesAlive() == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 7:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= getRoundSpawnCooldown(round)
					&& enemiesInThisRound < 30) {

				if (enemiesInThisRound <= 28) {
					this.addActor(new Enemy(0, 150, 3));
				} else {
					this.addActor(new Enemy(0, 150, 4));
				}

				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 30 && enemiesAlive() == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 8:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= getRoundSpawnCooldown(round)
					&& enemiesInThisRound < 35) {

				if (enemiesInThisRound <= 15) {
					this.addActor(new Enemy(0, 150, 3));
				} else if (enemiesInThisRound > 15 && enemiesInThisRound <= 28) {
					this.addActor(new Enemy(0, 150, 4));
				} else {
					this.addActor(new Enemy(0, 150, 5));
				}

				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 35 && enemiesAlive() == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 9:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= getRoundSpawnCooldown(round)
					&& enemiesInThisRound < 40) {

				if (enemiesInThisRound <= 5) {
					this.addActor(new Enemy(0, 150, 1));
				} else if (enemiesInThisRound > 5 && enemiesInThisRound <= 10) {
					this.addActor(new Enemy(0, 150, 2));
				} else if (enemiesInThisRound > 10 && enemiesInThisRound <= 20) {
					this.addActor(new Enemy(0, 150, 3));
				} else if (enemiesInThisRound > 20 && enemiesInThisRound <= 30) {
					this.addActor(new Enemy(0, 150, 4));
				} else {
					this.addActor(new Enemy(0, 150, 5));
				}

				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 40 && enemiesAlive() == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 10:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= getRoundSpawnCooldown(round)
					&& enemiesInThisRound < 100) {

				if (enemiesInThisRound <= 25) {
					this.addActor(new Enemy(0, 150, 1));
					this.addActor(new Enemy(-30, 150, 2));
					enemiesInThisRound++;
					enemiesInThisRound++;

				} else if (enemiesInThisRound > 25 && enemiesInThisRound <= 45) {
					this.addActor(new Enemy(0, 150, 3));
					enemiesInThisRound++;
				} else if (enemiesInThisRound > 45 && enemiesInThisRound <= 60) {
					this.addActor(new Enemy(0, 150, 4));
					enemiesInThisRound++;
				} else if (enemiesInThisRound > 60) {
					this.addActor(new Enemy(0, 150, 5));
					enemiesInThisRound++;

					counterSpawnCooldown = 0;
				}

				if (enemiesInThisRound == 100 && enemiesAlive() == 0) {
					round = 0;
					enemiesInThisRound = 0;
					counterRoundCooldown = 0;
				}
				break;
			}
		}
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();

		batch.begin();
		font.draw(batch, "Vidas: " + playerHealthPoints, 1035, 780);
		font.draw(batch, "Moedas: " + playerCoins, 10, 780);
		font.draw(batch, "Rodada: " + round, 500, 780);
		batch.end();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		font.dispose();
		batch.dispose();
	}

}