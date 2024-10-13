package Game.game.gameStage;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import Game.game.gameActors.Background;
import Game.game.gameActors.BomberTower;
import Game.game.gameActors.Bullet;
import Game.game.gameActors.Enemy;
import Game.game.gameActors.GameObject;
import Game.game.gameActors.SMGTower;
import Game.game.gameActors.SniperTower;
import Game.game.gameActors.Tower;
import Game.game.gameActors.TrapTower;
import Game.game.gameAssets.MapManager;
import Game.game.gameScreen.GameScreen;
import Game.game.rounds.Rounds;

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

	private Table store;

	private boolean isClicked = false;
	private Tower towerSelected;

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
		store.setScale(2f, 1.5f);

		store.setPosition(1070f, 750f);

		createStoreButtons();
		this.addActor(background);
		this.addActor(store);

		Gdx.input.setInputProcessor(this);

	}

	private void createStoreButtons() {
		// TODO Auto-generated method stub

		ImageButtonStyle style = new ImageButtonStyle();
		ImageButtonStyle style1 = new ImageButtonStyle();
		ImageButtonStyle style2 = new ImageButtonStyle();
		ImageButtonStyle style3 = new ImageButtonStyle();

		ImageButton Torre1 = new ImageButton(style);

		Torre1.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("cacto-loja.png"))));


		ImageButton Torre2 = new ImageButton(style1);
		Torre2.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("carrin.png"))));


		ImageButton Torre3 = new ImageButton(style2);
		Torre3.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("smg.png"))));

		ImageButton Torre4 = new ImageButton(style3);
		Torre4.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("plantaCapacete.png"))));

		Torre1.addListener(event -> {
			if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
				System.out.println("APERTOU O 1");

				if(playerCoins>=700){
					isClicked = true;
					towerSelected = new TrapTower(0, 0);
					playerCoins -= 700;

					return true;
				}else{
					System.out.println("Voce nao possui moedas o bastente");
				}
			}
			return false;
		});

		Torre2.addListener(event -> {
			if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
				System.out.println("APERTOU O 2");

				if(playerCoins>=400){
					isClicked = true;
					towerSelected = new BomberTower(0, 0);
					playerCoins -= 400;
					return true;
				}else{
					System.out.println("Voce nao possui moedas o bastente");
				}
			}
			return false;
		});

		Torre3.addListener(event -> {
			if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
				System.out.println("APERTOU O 3");

				if(playerCoins>=500){
					isClicked = true;
					towerSelected = new SniperTower(0, 0);
					playerCoins -= 500;
					return true;
				}else{
					System.out.println("Voce nao possui moedas o bastente");
				}
			}
			return false;
		});

		Torre4.addListener(event -> {
			if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
				System.out.println("APERTOU O 4");

				if(playerCoins>=200){
					isClicked = true;
					towerSelected = new SMGTower(0, 0);
					playerCoins -= 200;
					return true;
				}else{
					System.out.println("Voce nao possui moedas o bastente");
				}
			}
			return false;
		});

		store.add(Torre1).pad(10);
    	store.add(Torre2).pad(10);
    	store.add(Torre3).pad(10);
    	store.add(Torre4).pad(10);


	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub

		if (isClicked && button == Buttons.LEFT) {
			Vector3 temp_coord = new Vector3(screenX, screenY, 0);
			Vector3 coords = ortho.unproject(temp_coord);

			screenX = (int) coords.x;
			screenY = (int) coords.y;

            if (!isCollidingWithLayer2(screenX, screenY)) {
                setTower(towerSelected, screenX, screenY);
            }

			return true;
		}

		return super.touchDown(screenX, screenY, pointer, button);

	}

    private boolean isCollidingWithLayer2(int x, int y) {
        // Supondo que você tenha um método para obter a camada 2 do tilemap
        TiledMapTileLayer layer2 = (TiledMapTileLayer) background.getTileMap().getLayers().get("Camada de Blocos 2");

        // Converte as coordenadas de tela para coordenadas de tile
        int tileX = x / layer2.getTileWidth();
        int tileY = y / layer2.getTileHeight();

        // Verifica se o tile na posição (tileX, tileY) está bloqueado
        TiledMapTileLayer.Cell cell = layer2.getCell(tileX, tileY);
        TiledMapTileLayer.Cell cellAbove = layer2.getCell(tileX, tileY + 1);
        TiledMapTileLayer.Cell cellRight = layer2.getCell(tileX + 1, tileY);

        return (cell != null && cell.getTile() != null) ||
            (cellAbove != null && cellAbove.getTile() != null) ||
            (cellRight != null && cellRight.getTile() != null);
    }

	private void setTower(Tower towerSelected, int screenX, int screenY) {
		// TODO Auto-generated method stub

		if (towerSelected instanceof SMGTower) {

			this.addActor(new SMGTower(screenX, screenY));
		}
		if (towerSelected instanceof BomberTower) {

			this.addActor(new BomberTower(screenX, screenY));
		}
		if (towerSelected instanceof SniperTower) {

			this.addActor(new SniperTower(screenX, screenY));
		}
		if (towerSelected instanceof TrapTower) {

			this.addActor(new TrapTower(screenX, screenY));
		}

		isClicked = false;

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
		} else if(background.getTypeMap() == 2) {
			rounds.spawnMap2Enemies(getActors(), enemiesAlive(), background.getTypeMap());
		}else {
			rounds.spawnMap3Enemies(getActors(), enemiesAlive(), background.getTypeMap());
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
		font.draw(batch, "Sóis: " + playerCoins, 10, 780);
        batch.draw(new Texture(Gdx.files.internal("sol.png")), 200, 740, 40, 40);
		font.draw(batch, "Rodada: " + rounds.getRound(), 330, 780);
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
