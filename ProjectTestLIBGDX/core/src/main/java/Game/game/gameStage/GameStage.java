package Game.game.gameStage;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import Game.game.gameActors.*;
import Game.game.rounds.Rounds;
import Game.game.gameAssets.MapSoundManager;

public class GameStage extends Stage {

	private OrthographicCamera ortho;
	private Background background;

	private int playerHealthPoints;
	private int playerCoins;

	private BitmapFont font;
	private SpriteBatch batch;

	private Rounds rounds;

	private MapSoundManager soundManager;

	public GameStage() {
		// TODO Auto-generated constructor stub
		super();

		ortho = new OrthographicCamera();
		ortho.setToOrtho(false, 1280, 736);
		background = new Background(ortho);

		playerHealthPoints = 100; // definicao da quantidade de vidas do jogador
		playerCoins = 400;

		font = new BitmapFont();
		font.setColor(Color.WHITE);

		batch = new SpriteBatch();

		rounds = new Rounds();

		soundManager = new MapSoundManager();
		soundManager.loadSounds();

		if (background.getTypeMap() == 1) {
			soundManager.playMusic("morning");
		} else {
			soundManager.playMusic("night");
		}

		this.addActor(background);

		Gdx.input.setInputProcessor(this);

	}

	public void generateActors() {

		// Spawn de torres
		// forma temporaria de spawnar ate a juncao
		this.addActor(new TrapTower(410, 100));

		this.addActor(new BomberTower(445, 100));

		this.addActor(new SniperTower(470, 100));

	}

	public void spawnSMG() {
		this.addActor(new SMGTower(380, 100));
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);

		background.act(delta);

		rounds.updateSpawnCooldown();

		if (background.getTypeMap() == 1) {
			// soundManager.playMusic("morning");
			rounds.spawnMap1Enemies(getActors(), enemiesAlive(), background.getTypeMap());
		} else {
			// soundManager.playMusic("night");
			rounds.spawnMap2Enemies(getActors(), enemiesAlive(), background.getTypeMap());
		} // rounds.spawnMap2Enemies(getActors(), enemiesAlive());
			// rounds.spawnMap2Enemies(getActors(), enemiesAlive());

		if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
			generateActors();
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
			spawnSMG();
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {

			background.changeBackground();
		}

		// loop percorrendo todos os Atores do GameStage
		// este loop trata todos os eventos
		for (int i = 0; i < this.getActors().size; i++) {

			// Act de todos os GameObjects
			if (this.getActors().get(i) instanceof GameObject && (this.getActors().get(i) instanceof Enemy == false)) {
				this.getActors().get(i).act(delta);
			}
		}

		towersShoot();
		enemyAttack();
		deleteBullets();
		deleteEnemies();

		// System.out.println(Gdx.input.getX() + "-" + Gdx.input.getY());
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

			if (this.getActors().get(i) instanceof Tower) {

				Tower towerAux = (Tower) this.getActors().get(i);

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
				if (this.getActors().get(i).getX() > 1279
						&& !((Enemy) this.getActors().get(i)).getAlreadyDoneDamage()) {

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
	//Projeto de loja

	/*
	 * 
	 * @Override public boolean touchDown(int screenX, int screenY, int pointer, int
	 * button) { // TODO Auto-generated method stub
	 * 
	 * if (button == Input.Buttons.LEFT) { generateStore(Gdx.input.getX(),
	 * Gdx.input.getX()); return true; } return false;
	 * 
	 * }
	 * 
	 * private void generateStore(int x, int y) { // TODO Auto-generated method stub
	 * 
	 * Table table = new Table(); table.setFillParent(true);
	 * 
	 * TextButton.TextButtonStyle textButtonStyle = new
	 * TextButton.TextButtonStyle(); textButtonStyle.font = font;
	 * 
	 * 
	 * 
	 * TextButton BomberTower = new TextButton("TrapTower", textButtonStyle);
	 * TextButton SniperTower = new TextButton("SniperTower", textButtonStyle);
	 * TextButton SMGTower = new TextButton("SMGTower", textButtonStyle);
	 * 
	 * 
	 * BomberTower.addListener(event -> { if (event instanceof InputEvent &&
	 * ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
	 * System.out.println("Play button clicked"); // screen.changeStage(0);
	 * deleteStore(); return true; } return false; });
	 * 
	 * SniperTower.addListener(event -> { if (event instanceof InputEvent &&
	 * ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
	 * System.out.println("Settings button clicked"); // screen.changeStage(2);
	 * deleteStore(); return true; } return false; });
	 * 
	 * SMGTower.addListener(event -> { if (event instanceof InputEvent &&
	 * ((InputEvent) event).getType() == InputEvent.Type.touchDown) { deleteStore();
	 * return true; } return false; });
	 * 
	 * 
	 * BomberTower.setPosition(x, y);
	 * 
	 * table.add(BomberTower).fillX().uniformX().pad(20); table.row().pad(10, 0, 10,
	 * 0); table.add(SniperTower).fillX().uniformX().pad(20); table.row();
	 * table.add(SMGTower).fillX().uniformX().pad(20); this.addActor(table);
	 * 
	 * }
	 * 
	 * private void deleteStore() { // TODO Auto-generated method stub
	 * 
	 * for (int i = 0; i < this.getActors().size; i++) { if (this.getActors().get(i)
	 * instanceof Table) { this.getActors().removeIndex(i); } }
	 * 
	 * }
	 */

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();
		batch.begin();

		font.getData().setScale(3f, 3f);
		font.draw(batch, "Moedas: " + playerCoins, 10, 780);
		font.draw(batch, "Rodada: " + rounds.getRound(), 350, 780);
		font.draw(batch, "Vidas: " + playerHealthPoints, 610, 780);
		batch.end();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		font.dispose();
		batch.dispose();
		soundManager.dispose();
	}

}
