package Game.game.gameStage;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;

import Game.game.gameActors.*;
import Game.game.rounds.Rounds;
import Game.game.gameAssets.MapManager;
import Game.game.gameScreen.GameScreen;

@SuppressWarnings("unused")
public class GameStage extends Stage {

	private OrthographicCamera ortho;
	private Background background;

	private int playerHealthPoints;
	private int playerCoins;

	private BitmapFont font;
	private SpriteBatch batch;

	private Rounds rounds;

	private GameScreen screen;
	private MapManager soundManager;

	Table store;

	public GameStage() {
		// TODO Auto-generated constructor stub
		super();

		ortho = new OrthographicCamera();
		ortho.setToOrtho(false, 1280, 736);
		background = new Background(ortho);

		screen = new GameScreen();

		playerHealthPoints = 100; // definicao da quantidade de vidas do jogador
		playerCoins = 400;

		font = new BitmapFont();
		font.setColor(Color.WHITE);

		batch = new SpriteBatch();

		rounds = new Rounds();

		soundManager = new MapManager();
		soundManager.loadSounds();

		if (background.getTypeMap() == 1) {
			soundManager.playMusic("morning");
		} else if (background.getTypeMap() == 2) {
			soundManager.playMusic("night");
		} else if (background.getTypeMap() == 3) {
			soundManager.playMusic("telha");
		}

		store = new Table();

	
		store.setDebug(true);
		store.setTransform(true);
		store.setScale(3f,2.5f);

		store.setPosition(1050f, 750f);

		createStoreButtons();
		this.addActor(store);
		this.addActor(background);

		Gdx.input.setInputProcessor(this);

	}

	private void createStoreButtons() {
		// TODO Auto-generated method stub

		ButtonStyle style = new ButtonStyle();

		Button Torre1 = new Button(style);
		
		Torre1.setBackground(new Image(new Texture(Gdx.files.internal("plantaCapacete.png"))).getDrawable());

		Button Torre2 = new Button(style);
		
		Torre2.setBackground(new Image(new Texture(Gdx.files.internal("plantaCapacete.png"))).getDrawable());

		Button Torre3 = new Button(style);
		
		Torre3.setBackground(new Image(new Texture(Gdx.files.internal("plantaCapacete.png"))).getDrawable());

		Button Torre4 = new Button(style);
		
		Torre4.setBackground(new Image(new Texture(Gdx.files.internal("plantaCapacete.png"))).getDrawable());

		Torre1.addListener(event -> {
			if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
				System.out.println("APERTOU O 1");
				return true;
			}
			return false;
		});

		Torre2.addListener(event -> {
			if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
				System.out.println("APERTOU O 2");
				return true;
			}
			return false;
		});

		Torre3.addListener(event -> {
			if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
				System.out.println("APERTOU O 3");
				return true;
			}
			return false;
		});

		Torre4.addListener(event -> {
			if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
				System.out.println("APERTOU O 4");
				return true;
			}
			return false;
		});

		store.add(Torre1);

		store.add(Torre2);

		store.add(Torre3);

		store.add(Torre4);

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
		store.act(delta);

		rounds.updateSpawnCooldown();

		if (background.getTypeMap() == 1) {
			rounds.spawnMap1Enemies(getActors(), enemiesAlive(), background.getTypeMap());
		} else {
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
