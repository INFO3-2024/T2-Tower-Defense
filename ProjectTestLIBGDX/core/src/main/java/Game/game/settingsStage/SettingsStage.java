package Game.game.settingsStage;

import Game.game.gameAssets.MapManager;
import Game.game.gameScreen.GameScreen;
import Game.game.menuStage.MenuStage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SuppressWarnings("unused")
public class SettingsStage extends Stage {
    private static final int STAGE_INDEX = 3;
    private Image backgroundImage;
    private OrthographicCamera ortho;
    private BitmapFont font;
    private SpriteBatch batch;
    private GameScreen screen;
    private MapManager soundManager;
    private Table table;

    private MenuStage stageMenu;

    public SettingsStage(GameScreen screen) {
        super(new ScreenViewport());

        Gdx.input.setInputProcessor(this);

        ortho = new OrthographicCamera();
        ortho.setToOrtho(false, 1280, 736);

        soundManager = new MapManager();
        soundManager.loadSounds();

        table = new Table();
        table.setFillParent(true);
        this.addActor(table);

        this.screen = screen;

        createBackground();
        createButtons();
    }

    private void createBackground() {
        Texture backgroundTexture = new Texture(Gdx.files.internal("MenuBackground.jpeg"));
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        table.setBackground(backgroundImage.getDrawable());
    }
    private void createButtons() {
        BitmapFont font = new BitmapFont();
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.fontColor = Color.WHITE;
        textButtonStyle.font.getData().setScale(5f, 5f);

        TextButton playButton = new TextButton("Musica", textButtonStyle);
        TextButton muteButton = new TextButton("Mutar", textButtonStyle);
        TextButton exitButton = new TextButton("Voltar", textButtonStyle);

        playButton.addListener(event -> {
            if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
                System.out.println("Teste1 button clicked");
                soundManager.playMusic("morning");
                return true;
            }
            return false;
        });

        muteButton.addListener(event -> {
            if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
                System.out.println("Mute button clicked");
                soundManager.stopMusic();
                return true;
            }
            return false;
        });

        exitButton.addListener(event -> {
            if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
                screen.changeStage(1);
                return true;
            }
            return false;
        });

        table.add(playButton).fillX().uniformX().pad(20);
        table.row().pad(10, 0, 10, 0);
        table.add(muteButton).fillX().uniformX().pad(20);
        table.row();
        table.add(exitButton).fillX().uniformX().pad(20);
    }
}

