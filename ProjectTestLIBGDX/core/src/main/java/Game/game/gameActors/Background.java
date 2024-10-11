package Game.game.gameActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.*;

import com.badlogic.gdx.scenes.scene2d.*;

public class Background extends Actor {

	private TiledMap mapa1, mapa2;
	private OrthogonalTiledMapRenderer renderer;
	private int typeMap = 1;

	public Background(OrthographicCamera ortho) {
		// TODO Auto-generated constructor stub

		super();

		mapa1 = new TmxMapLoader().load("Mapa_Diurno.tmx");
		mapa2 = new TmxMapLoader().load("Mapa_Noturno.tmx");

		renderer = new OrthogonalTiledMapRenderer(mapa1);

		renderer.setView(ortho);
		// 1280, 736
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

	public void changeBackground() {
		// TODO Auto-generated method stub

		TiledMap aux = new TiledMap();

		if (renderer.getMap() == mapa1) {
			aux = mapa2;

		} else {
			aux = mapa1;

		}

		renderer.setMap(aux);

	}

	public int getTypeMap() {
		return typeMap;
	}

	public void setTypeMap(int typeMap) {
		this.typeMap = typeMap;
	}

}
