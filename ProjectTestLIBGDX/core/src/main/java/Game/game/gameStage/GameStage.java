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

		// act de todos os game objects
		for (int i = 0; i < this.getActors().size; i++) {
			if (this.getActors().get(i) instanceof GameObject) {
				this.getActors().get(i).act(delta);

			}
		}

		// Inimigo tomando dano
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			for(int i = 0; i < this.getActors().size; i++) {
				if(this.getActors().get(i) instanceof Enemy) {
					Enemy enemyAux = (Enemy) this.getActors().get(i);
					enemyAux.receiveDamage(1);
				}
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
