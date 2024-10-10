package Game.game.gameActors;

import com.badlogic.gdx.graphics.g2d.Batch;
import Game.game.gameAssets.TowerTexture;

public class SniperTower extends Tower {

	public SniperTower(int positionX, int positionY) {
		setPosition(positionX, positionY);
		imagem = TowerTexture.getInstance().getTexture("SniperTower"); 
		fireRate = 3; // Cadencia de disparo temporaria
		shootingRange = 800;
		projectileSpeed = 100;
		damage = 5;
		bulletTipe = Game.game.gameActors.bulletTipe.NORMAL_PROJECTILE;
	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		batch.draw(imagem, getX(), getY(), imagem.getWidth(), imagem.getHeight());

	}
}
