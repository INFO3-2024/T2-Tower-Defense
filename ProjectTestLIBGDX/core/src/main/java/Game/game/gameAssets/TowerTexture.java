package Game.game.gameAssets;

import Game.game.gameActors.TrapTower;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TowerTexture extends TextureManager {
    private static TowerTexture instance;

    private TowerTexture() {
        loadTextures(); 
    }

    public static TowerTexture getInstance() {
        if (instance == null) {
            instance = new TowerTexture();
        }
        return instance;
    }

    @Override
    public void loadTextures() {
        textures.put("TrapTower", new Texture(Gdx.files.internal("trap_tower_day1.png")));
        textures.put("BomberTower", new Texture(Gdx.files.internal("bomber_tower_day1.png")));
        textures.put("SMGTower", new Texture(Gdx.files.internal("smg_tower_day.png")));
        textures.put("SniperTower", new Texture(Gdx.files.internal("sniper_tower_day1.png")));
    }
}