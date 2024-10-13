package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import Game.game.gameAssets.TowerTexture;

public class SniperTower extends Tower {

	public SniperTower(int positionX, int positionY) {
		setPosition(positionX, positionY);
		imagem = TowerTexture.getInstance().getTexture("SniperTower");

		if (imagem != null) {
            this.imagemRegion = new TextureRegion(imagem);
        } else {
            Gdx.app.error("SniperTower", "Texture 'SniperTower' could not be loaded");
        }

		fireRate = 3; // Cadencia de disparo temporaria
		shootingRange = 800;
		projectileSpeed = 100;
		damage = 5;
		price = 500;
		bulletTipe = Game.game.gameActors.bulletTipe.PROJETIL_SNIPERTOWER;
	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		Texture currentFrameTexture = TowerTexture.getInstance().getSniperTowerFrameForAngle(towerAngle);

        if (currentFrameTexture != null) {
            TextureRegion textureRegion = new TextureRegion(currentFrameTexture);
            batch.draw(textureRegion, getX(), getY(),
                    textureRegion.getRegionWidth() / 2, textureRegion.getRegionHeight() / 2,
                    textureRegion.getRegionWidth(), textureRegion.getRegionHeight(),
                    1, 1, // escala
                    0); // Não rotaciona a imagem
        } else {
            Gdx.app.error("SniperTower", "No frame available for the current angle");
        }

	}
}
