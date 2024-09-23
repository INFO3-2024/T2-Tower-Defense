package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.*;

import com.badlogic.gdx.scenes.scene2d.*;

public class Background extends Actor {

	private TiledMap mapa1, mapa2;
	private OrthogonalTiledMapRenderer renderer;
	private float deltaX = 0;

	public Background(OrthographicCamera ortho) {
		// TODO Auto-generated constructor stub

		super();

		mapa1 = new TmxMapLoader().load("novoMapa.tmx");
		mapa2 = new TmxMapLoader().load("prototipoMapa.tmx");

		renderer = new OrthogonalTiledMapRenderer(mapa1);

		renderer.setView(ortho);
		// 640, 480
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);

		deltaX += delta;

		if (deltaX > 10) {
			changeBackground();
			deltaX = 0;
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);

		renderer.render();

	}

	private void changeBackground() {
		// TODO Auto-generated method stub

		if (renderer.getMap() == mapa1)
			renderer.setMap(mapa2);
		else
			renderer.setMap(mapa1);

	}

}
