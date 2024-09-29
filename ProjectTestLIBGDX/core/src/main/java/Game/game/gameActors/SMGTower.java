package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class SMGTower extends Tower {

	public SMGTower(int positionX, int positionY) {
		setPosition(positionX, positionY);
		imagem = new Texture(Gdx.files.internal("SMGTower.png"));
		fireRate = 0.2; // Cadencia de disparo temporaria
		shootingRange = 200;
		projectileSpeed = 10;
		damage = 2;
		bulletTipe = Game.game.gameActors.bulletTipe.NORMAL_PROJECTILE;
	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		batch.draw(imagem, getX(), getY(), imagem.getWidth(), imagem.getHeight());

	}

}
