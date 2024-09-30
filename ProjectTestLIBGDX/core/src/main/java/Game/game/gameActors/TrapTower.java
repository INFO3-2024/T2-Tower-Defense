package Game.game.gameActors;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

public class TrapTower extends Tower{

	public TrapTower(int positionX, int positionY) {
		setPosition(positionX, positionY);
		imagem = new Texture(Gdx.files.internal("TrapTower.png"));
		fireRate = 3;
		shootingRange = 800;
		projectileSpeed = 10;
		damage = 3;
		bulletTipe = Game.game.gameActors.bulletTipe.NORMAL_PROJECTILE;
	}
	
	//IMPORTANTEEEEEEEEEEEEEEEEEEEEE
	//IMPLEMENTAÇÃO MUITO TEMPORARIA APENAS PARA FACILITAMENTO
	//DO TRABALHO PARA O GRUPO DE ASSETS
	public ArrayList<Bullet> tryToShoot(Array<Actor> listaAtores) {

		checkEnemiesInRange(listaAtores);

		Vector2 positionToGo = getFarthestEnemyPosition();

		elapsedTime += Gdx.graphics.getDeltaTime();

		if (!enemiesInRange.isEmpty() && elapsedTime >= fireRate) {

			elapsedTime = 0;

			bulletsArray.add(new Bullet(this.getX(), this.getY(), this.getX() - 100, this.getY() + 400, projectileSpeed,
					damage, bulletTipe));
		}

		return bulletsArray;

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
