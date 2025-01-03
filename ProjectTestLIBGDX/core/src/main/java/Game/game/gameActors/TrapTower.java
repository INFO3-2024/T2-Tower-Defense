package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import Game.game.gameAssets.TowerTexture; // Importação necessária

public class TrapTower extends Tower {

    
    // Construtor
    public TrapTower(int positionX, int positionY) {
        setPosition(positionX, positionY);
        imagem = TowerTexture.getInstance().getTexture("TrapTower");

        // Converter Texture para TextureRegion
        if (imagem != null) {
            this.imagemRegion = new TextureRegion(imagem);
        } else {
            Gdx.app.error("TrapTower", "Texture 'TrapTower' could not be loaded");
        }

        fireRate = 1.3;
        shootingRange = 300;
        projectileSpeed = 100;
        damage = 7;
        price = 700;
        bulletTipe = Game.game.gameActors.bulletTipe.PROJETIL_TRAPTOWER;
    }

    @Override
	public void act(float delta) {
		super.act(delta);
	}

    public void draw(Batch batch, float parentAlpha) {
        // Obtenha o frame correto baseado no ângulo da torre
        Texture currentFrameTexture = TowerTexture.getInstance().getTrapTowerFrameForAngle(towerAngle);

        if (currentFrameTexture != null) {
            TextureRegion textureRegion = new TextureRegion(currentFrameTexture);
            batch.draw(textureRegion, getX(), getY(),
                    textureRegion.getRegionWidth() / 2, textureRegion.getRegionHeight() / 2,
                    textureRegion.getRegionWidth(), textureRegion.getRegionHeight(),
                    1, 1, // escala
                    0); // Não rotaciona a imagem
        } else {
            Gdx.app.error("TrapTower", "No frame available for the current angle");
        }
    }

}
