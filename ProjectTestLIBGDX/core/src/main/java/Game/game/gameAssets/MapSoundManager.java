package Game.game.gameAssets;

import com.badlogic.gdx.Gdx;

public class MapSoundManager extends SoundManager {

    @Override
    public void loadSounds() {
        // Carrega as músicas para os diferentes estágios do mapa
        musicTracks.put("night", Gdx.audio.newMusic(Gdx.files.internal("sounds/MapNight.mp3")));
        musicTracks.put("morning", Gdx.audio.newMusic(Gdx.files.internal("sounds/MapMorning.mp3")));
        musicTracks.put("telha", Gdx.audio.newMusic(Gdx.files.internal("sounds/MapTelha.mp3")));
        // Adicione outros estágios do mapa aqui
    }
}
