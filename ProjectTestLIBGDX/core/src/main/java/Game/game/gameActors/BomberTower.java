package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import Game.game.gameAssets.TowerTexture;

public class BomberTower extends Tower{

	//construtor 
	public BomberTower(int positionX, int positionY) {
		setPosition(positionX, positionY);
		//Atribuição a imagem 
		imagem = TowerTexture.getInstance().getTexture("BomberTower");

		//conversão de tipo 
		if (imagem != null) {
			this.imagemRegion = new TextureRegion(imagem);
		} else {
			Gdx.app.error("BomberTower", "Texture 'BomberTower' could not be loaded");
		}

		fireRate = 0.2; // Cadencia de disparo temporaria
		shootingRange = 200;
		projectileSpeed = 10;
		damage = (float) 2.5;
		//tipo da bala 
		bulletTipe = Game.game.gameActors.bulletTipe.NORMAL_PROJECTILE;
	}

	//ação 
	@Override
	public void act(float delta) {
		super.act(delta);
	}

	//carrega 
	@Override
	public void draw(Batch batch, float parentAlpha) {
		Texture currentFrameTexture = TowerTexture.getInstance().getSMGTowerFrameForAngle(towerAngle);

        if (currentFrameTexture != null) {
            TextureRegion textureRegion = new TextureRegion(currentFrameTexture);
            batch.draw(textureRegion, getX(), getY(),
                    textureRegion.getRegionWidth() / 2, textureRegion.getRegionHeight() / 2,
                    textureRegion.getRegionWidth(), textureRegion.getRegionHeight(),
                    1, 1, // escala
                    0); // Não rotaciona a imagem
        } else {
            Gdx.app.error("BomberTower", "No frame available for the current angle");
        }

	}

}
