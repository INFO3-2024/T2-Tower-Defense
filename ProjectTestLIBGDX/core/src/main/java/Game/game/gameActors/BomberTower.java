package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class BomberTower extends Tower{

	public BomberTower(int positionX, int positionY) {
		setPosition(positionX, positionY);
		imagem = new Texture(Gdx.files.internal("BomberTower.png"));
		fireRate = 2.5; // Cadencia de disparo temporaria
		shootingRange = 150;
		projectileSpeed = 60;
		damage = 4;
		bulletTipe = Game.game.gameActors.bulletTipe.EXPLOSIVE_PROJECTILE;
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
