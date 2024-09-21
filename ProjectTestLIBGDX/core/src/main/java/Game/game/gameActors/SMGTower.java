package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class SMGTower extends Tower {

	public SMGTower(int positionX, int positionY) {
		setPosition(positionX, positionY);
		imagem = new Texture(Gdx.files.internal("SMGTower.png"));
		fireRate = 5; // Cadencia de disparo temporaria
		
	}

	@Override
	public void shoot() {

		elapsedTime += Gdx.graphics.getDeltaTime();

		if (elapsedTime >= fireRate) {
			elapsedTime = 0;
		}

	}

	@Override
	public void act(float delta) {
		super.act(delta);
		shoot();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		range = new ShapeRenderer();
		
		batch.draw(imagem, getX(), getY(), imagem.getWidth(), imagem.getHeight());

	}
	public void dispose() {
		imagem.dispose();
		range.dispose();
	}
}
