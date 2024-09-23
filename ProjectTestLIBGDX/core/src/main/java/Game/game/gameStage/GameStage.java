package Game.game.gameStage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.scenes.scene2d.*;

import Game.game.gameActors.*;

public class GameStage extends Stage {

	private OrthographicCamera ortho;
	private Background background;

	public GameStage() {
		// TODO Auto-generated constructor stub
		super();
		ortho = new OrthographicCamera();
		ortho.setToOrtho(false, 640, 480);
		background = new Background(ortho);
		this.addActor(background);

	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);

		background.act(delta);

		// Spawn de torres
		// forma temporaria de spawnar ate a juncao
		if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
			this.addActor(new SMGTower(100, 100));
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.T)) {
			this.addActor(new TrapTower(150, 100));
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.B)) {
			this.addActor(new BomberTower(200, 100));
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
			this.addActor(new SniperTower(250, 100));
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
			
			//Act de todos os GameObjects
			if (this.getActors().get(i) instanceof GameObject) {
				this.getActors().get(i).act(delta);
			}
			
			//Causando dano a todos os inimigos
			//Forma temporaria!!!
			if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) && this.getActors().get(i) instanceof Enemy) {
				Enemy enemyAux = (Enemy) this.getActors().get(i);
				enemyAux.receiveDamage(1);
			}
			
			//torres atirando
			//isso posteriormente sera feito usando polimorfismo
			//ainda nao esta pq preciso do mapa com os caminhos para
			//programar a traptower
			
			/*
			if(this.getActors().get(i) instanceof SMGTower) {
				SMGTower towerAux = (SMGTower) this.getActors().get(i);
				towerAux.tryToShoot(getActors());
			}
			
			if(this.getActors().get(i) instanceof SniperTower) {
				SniperTower towerAux = (SniperTower) this.getActors().get(i);
				towerAux.tryToShoot(getActors());
			}
			*/
			if(this.getActors().get(i) instanceof BomberTower) {
				BomberTower towerAux = (BomberTower) this.getActors().get(i);
				towerAux.tryToShoot(getActors());
			}
			
			
		}

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();

	}

}
