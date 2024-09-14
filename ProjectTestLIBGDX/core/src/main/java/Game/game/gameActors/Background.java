package Game.game.gameActors;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.*;

import com.badlogic.gdx.scenes.scene2d.*;

public class Background extends Actor {

	private TiledMap mapa;
	private OrthogonalTiledMapRenderer renderer;

	public Background(OrthographicCamera ortho) {
		// TODO Auto-generated constructor stub

		super();

		mapa = new TmxMapLoader().load("novoMapa.tmx");

		renderer = new OrthogonalTiledMapRenderer(mapa);

		renderer.setView(ortho);
		// 640, 480
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);

	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);

		renderer.render();

	}

}
