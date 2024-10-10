package Game.game.gameAssets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class TowerTexture extends TextureManager {
    private static TowerTexture instance;

    //Declaração do angulo inicial da Torre
    private float towerAngle = 0f; 

    private ArrayList<Texture> trapTowerFrames; // Adiciona um ArrayList para os frames da TrapTower

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
        // Texturas individuais para torres estáticas
        textures.put("TrapTower", new Texture(Gdx.files.internal("trapTowerAssets/trap_tower_day1.png")));
        textures.put("BomberTower", new Texture(Gdx.files.internal("bomber_tower_day1.png")));
        textures.put("SMGTower", new Texture(Gdx.files.internal("smg_tower_day.png")));
        textures.put("SniperTower", new Texture(Gdx.files.internal("sniper_tower_day1.png")));

        // Carregar os frames da animação para a TrapTower
        trapTowerFrames = new ArrayList<>();
        for (int i = 1; i < 40; i++) {
            trapTowerFrames.add(new Texture(Gdx.files.internal("trapTowerAssets/trap_tower_day" + i + ".png")));
        }
    }

    // Método para obter o frame da animação da TrapTower
    public Texture getTrapTowerFrame(int index) {
        return trapTowerFrames.get(index % trapTowerFrames.size());
    }
    
    public Texture getTrapTowerFrameForAngle(float angle) {
        int totalFrames = trapTowerFrames.size();
        float degreesPerFrame = 360f / totalFrames;

        // Calcula o índice do frame com base no ângulo
        int frameIndex = (int)(angle / degreesPerFrame) % totalFrames;

        // Retorna a textura correspondente ao frame calculado
        return trapTowerFrames.get(frameIndex);
    }

   
}
