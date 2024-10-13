package Game.game.gameActors;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Background extends Actor {

	private TiledMap mapa1, mapa2,mapa3;
	private OrthogonalTiledMapRenderer renderer;
	private int typeMap = 1;

	public Background(OrthographicCamera ortho) {
		// TODO Auto-generated constructor stub

		super();

		mapa1 = new TmxMapLoader().load("Mapa_Diurno.tmx");
		mapa2 = new TmxMapLoader().load("Mapa_Noturno.tmx");
		mapa3 = new TmxMapLoader().load("Mapa_Telhado.tmx");

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

		} else if(renderer.getMap() == mapa2) {
			aux = mapa3;

		}else {
			aux = mapa1;
		}

		renderer.setMap(aux);

	}

	public boolean isMap1() {
		return renderer.getMap() == mapa1;
	}
	public boolean isMap2() {
		return renderer.getMap() == mapa2;
	}

	public int getTypeMap() {
		return typeMap;
	}

	public void setTypeMap(int typeMap) {
		this.typeMap = typeMap;
	}

    public TiledMap getTileMap() {
        return renderer.getMap();
    }
}
