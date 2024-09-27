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
	private BitmapFont font;
	private SpriteBatch batch;

	public GameStage() {
		// TODO Auto-generated constructor stub
		super();
		
		ortho = new OrthographicCamera();
		ortho.setToOrtho(false, 640, 480);
		background = new Background(ortho);
		this.addActor(background);
		playerHealthPoints = 100; //definicao da quantidade de vidas do jogador
		font = new BitmapFont(); 
		font.setColor(Color.WHITE);
		font.getData().setScale(3.5f, 3.5f);
		batch = new SpriteBatch();
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);

		background.act(delta);

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

		// Spawn dos inimigos
		// forma temporaria ate a juncao
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			this.addActor(new Enemy(-80, 150, 1));
			this.addActor(new Enemy(-60, 150, 2));
			this.addActor(new Enemy(-40, 150, 3));
			this.addActor(new Enemy(-20, 150, 4));
			this.addActor(new Enemy(0, 150, 5));
		}		

		// loop percorrendo todos os Atores do GameStage
		// este loop trata todos os eventos
		for (int i = 0; i < this.getActors().size; i++) {
			
			// Act de todos os GameObjects
			if (this.getActors().get(i) instanceof GameObject) {
				this.getActors().get(i).act(delta);
			}

			// Causando dano a todos os inimigos
			// Forma temporaria!!!
			if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && this.getActors().get(i) instanceof Enemy) {
				Enemy enemyAux = (Enemy) this.getActors().get(i);
				enemyAux.receiveDamage(1);
			}
			
			//teste para ver se o inimigo saiu da tela
			// e caso sim, diminuir as vidas do jogador
			//com base no tipo de inimigo
			if (this.getActors().get(i) instanceof Enemy) { 
				
				//se o inimigo tiver saido da tela e se ele nao tiver dado dano ainda ao jogador
				if (this.getActors().get(i).getX() > 639 && !((Enemy) this.getActors().get(i)).getAlreadyDoneDamage()) {
			        
					if(((Enemy) this.getActors().get(i)).getHealthPoints() > 0) {
			        	
						int damageEnemy = ((Enemy) this.getActors().get(i)).getDamage();
			        	playerHealthPoints = playerHealthPoints - damageEnemy;
			        	((Enemy) this.getActors().get(i)).setAlreadyDoneDamage(true); // define que o inimigo em i já deu dano no jogador
			        }
			    }
			}		
			
			
			// torres atirando
			// isso posteriormente sera feito usando polimorfismo
			// ainda nao esta pq preciso do mapa com os caminhos para
			// programar a traptower

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

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();
		
		batch.begin();
		font.draw(batch, "Vidas: " + playerHealthPoints, 1000, 780);
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
