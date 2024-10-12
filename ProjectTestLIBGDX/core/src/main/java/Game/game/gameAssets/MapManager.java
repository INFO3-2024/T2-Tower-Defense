package Game.game.gameAssets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

@SuppressWarnings("unused")
public class MapManager extends SoundManager {

    @Override
    public void loadSounds() {
        musicTracks.put("night", Gdx.audio.newMusic(Gdx.files.internal("sounds/MapNight.mp3")));
        musicTracks.put("morning", Gdx.audio.newMusic(Gdx.files.internal("sounds/MapMorning.mp3")));
        musicTracks.put("telha", Gdx.audio.newMusic(Gdx.files.internal("sounds/MapTelha.mp3")));
    }
}
