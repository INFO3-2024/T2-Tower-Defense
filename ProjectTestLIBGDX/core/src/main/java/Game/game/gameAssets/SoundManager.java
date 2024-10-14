package Game.game.gameAssets;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Gdx;
import java.util.HashMap;

@SuppressWarnings("unused")
public abstract class SoundManager {

    protected HashMap<String, Music> musicTracks;
    protected Music currentMusic;

    public SoundManager() {
        musicTracks = new HashMap<>();
    }

    public abstract void loadSounds();

    public Music getMusic(String name) {
        return musicTracks.get(name);
    }

    public void playMusic(String mapStage) {
        if (currentMusic != null && currentMusic.isPlaying()) {
            currentMusic.stop();
        }

        currentMusic = getMusic(mapStage);
        if (currentMusic != null) {
            currentMusic.setLooping(true);
            currentMusic.play();
        }
    }
    public void stopMusic(){
        if (currentMusic != null) {
            currentMusic.stop(); 
        }
    }
    
    public void setVolume(int volume) {
    	currentMusic.setVolume(volume);
    }

    public void dispose() {
        stopMusic();
        currentMusic.dispose();

        for (Music music : musicTracks.values()) {
            music.dispose();
        }
        musicTracks.clear();
    }
}
