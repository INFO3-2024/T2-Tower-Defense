package Game.game.gameActors;

import Game.game.gameAssets.TowerTexture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion; // Importação necessária
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;

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

        fireRate = 3;
        shootingRange = 800;
        projectileSpeed = 10;
        damage = 3;
        bulletTipe = Game.game.gameActors.bulletTipe.NORMAL_PROJECTILE;
        bulletsArray = new ArrayList<>(); // Inicializa o array de balas
    }

    // Implementação temporária de tiro
    public ArrayList<Bullet> tryToShoot(Array<Actor> listaAtores) {
        checkEnemiesInRange(listaAtores);
        Vector2 positionToGo = getFarthestEnemyPosition();

        if (positionToGo != null) {
            updateTowerAngle(positionToGo);
        }
        elapsedTime += Gdx.graphics.getDeltaTime();

        if (!enemiesInRange.isEmpty() && elapsedTime >= fireRate) {
            elapsedTime = 0;
            bulletsArray.add(new Bullet(this.getX(), this.getY(), positionToGo.x, positionToGo.y, projectileSpeed, damage, bulletTipe));

            // Altera o frame para simular a animação no disparo
            currentFrame = (currentFrame + 1) % 40;
        }

        return bulletsArray;
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
