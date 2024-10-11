package Game.game.gameAssets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class TowerTexture extends TextureManager {
    private static TowerTexture instance;

    //Declaração do angulo inicial da Torre
    private float towerAngle = 0f; 

    private ArrayList<Texture> trapTowerFrames; 
    private ArrayList<Texture> smgTowerFrames;
    private ArrayList<Texture> sniperTowerFrames;
    private ArrayList<Texture> bomberTowerFrames;

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
        textures.put("BomberTower", new Texture(Gdx.files.internal("bomberTowerAssets/bomber_tower_day1.png")));
        textures.put("SMGTower", new Texture(Gdx.files.internal("smgTowerAssets/smg_tower_day1.png")));
        textures.put("SniperTower", new Texture(Gdx.files.internal("sniperTowerAssets/sniper_tower_day1.png")));

        // Carregar os frames da animação para a TrapTower
        trapTowerFrames = new ArrayList<>();
        smgTowerFrames = new ArrayList<>();
        sniperTowerFrames = new ArrayList<>();
        bomberTowerFrames = new ArrayList<>(); 

        for (int i = 1; i < 40; i++) {
            trapTowerFrames.add(new Texture(Gdx.files.internal("trapTowerAssets/trap_tower_day" + i + ".png")));
            smgTowerFrames.add(new Texture(Gdx.files.internal("smgTowerAssets/smg_tower_day" + i + ".png")));
            sniperTowerFrames.add(new Texture(Gdx.files.internal("sniperTowerAssets/sniper_tower_day" + i + ".png")));
            bomberTowerFrames.add(new Texture(Gdx.files.internal("bomberTowerAssets/bomber_tower_day" + i + ".png")));
        }

    
    }

    // Método para obter o frame da animação da TrapTower
    public Texture getTrapTowerFrame(int index) {
        return trapTowerFrames.get(index % trapTowerFrames.size());
    }
    public Texture getSMGTowerFrame(int index) {
        return smgTowerFrames.get(index % smgTowerFrames.size());
    }
    public Texture getSniperTowerFrame(int index) {
        return sniperTowerFrames.get(index % sniperTowerFrames.size());
    }
    public Texture getBomberTowerFrame(int index) {
        return bomberTowerFrames.get(index % bomberTowerFrames.size());
    }
    

    public Texture getTrapTowerFrameForAngle(float angle) {
        int totalFrames = trapTowerFrames.size();
        float degreesPerFrame = 360f / totalFrames;
        // Calcula o índice do frame com base no ângulo
        int frameIndex = (int)(angle / degreesPerFrame) % totalFrames;
        // Retorna a textura correspondente ao frame calculado
        return trapTowerFrames.get(frameIndex);
    }
    public Texture getSMGTowerFrameForAngle(float angle) {
        int totalFrames = smgTowerFrames.size();
        float degreesPerFrame = 360f / totalFrames;
        // Calcula o índice do frame com base no ângulo
        int frameIndex = (int)(angle / degreesPerFrame) % totalFrames;
        // Retorna a textura correspondente ao frame calculado
        return smgTowerFrames.get(frameIndex);
    }
    public Texture getSniperTowerFrameForAngle(float angle) {
        int totalFrames = sniperTowerFrames.size();
        float degreesPerFrame = 360f / totalFrames;
        // Calcula o índice do frame com base no ângulo
        int frameIndex = (int)(angle / degreesPerFrame) % totalFrames;
        // Retorna a textura correspondente ao frame calculado
        return sniperTowerFrames.get(frameIndex);
    }

    public Texture getBomberTowerFrameForAngle(float angle) {
        int totalFrames = bomberTowerFrames.size();
        float degreesPerFrame = 360f / totalFrames;
        // Calcula o índice do frame com base no ângulo
        int frameIndex = (int)(angle / degreesPerFrame) % totalFrames;
        // Retorna a textura correspondente ao frame calculado
        return bomberTowerFrames.get(frameIndex);
    }

   
}
