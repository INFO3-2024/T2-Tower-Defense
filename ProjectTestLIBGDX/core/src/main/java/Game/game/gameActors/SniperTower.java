package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class SniperTower extends Tower{

	public SniperTower(int positionX, int positionY) {
		setPosition(positionX, positionY);
		imagem = new Texture(Gdx.files.internal("SniperTower.png"));
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
