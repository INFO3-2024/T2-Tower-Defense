package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class TrapTower extends Tower{

	public TrapTower(int positionX, int positionY) {
		setPosition(positionX, positionY);
		imagem = new Texture(Gdx.files.internal("TrapTower.png"));
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
