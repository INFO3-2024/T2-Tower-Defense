package Game.game.gameAssets;

import com.badlogic.gdx.graphics.Texture;
import java.util.HashMap;

public abstract class TextureManager {
    
    protected HashMap<String, Texture> textures;

    public TextureManager() {
        textures = new HashMap<>();
    }

    // Método abstrato para ser implementado nas subclasses
    public abstract void loadTextures();

    // Método para obter a textura pelo nome
    public Texture getTexture(String name) {
        return textures.get(name);
    }

    // Método para liberar as texturas
    public void dispose() {
        for (Texture texture : textures.values()) {
            texture.dispose();
        }
        textures.clear();
    }
}