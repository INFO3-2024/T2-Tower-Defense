package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import Game.game.gameAssets.TowerTexture;

public class SMGTower extends Tower {

	public SMGTower(int positionX, int positionY) {
		setPosition(positionX, positionY);
		imagem = TowerTexture.getInstance().getTexture("SMGTower"); 
		fireRate = 0.2; // Cadencia de disparo temporaria
		shootingRange = 200;
		projectileSpeed = 10;
		damage = (float) 2.5;
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
