package Game.game.gameMenu;

import Game.game.gameScreen.GameScreen;
import Game.game.gameStage.GameStage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import Game.game.gameActors.Background;
import Game.game.gameAssets.MapSoundManager;

public class MainMenu extends Stage {

    private static final int STAGE_INDEX = 0;
    private OrthographicCamera ortho;
    private BitmapFont font;
    private SpriteBatch batch;
    private GameScreen screen;
    private MapSoundManager soundManager;
    private Table table;

    public MainMenu(GameScreen screen) {
        super(new ScreenViewport());

        Gdx.input.setInputProcessor(this);

        ortho = new OrthographicCamera();
        ortho.setToOrtho(false, 1280, 736);

        soundManager = new MapSoundManager();
        soundManager.loadSounds();

        table = new Table();
        table.setFillParent(true);
        this.addActor(table);

        this.screen = screen;

        createButtons();
    }

    private void createButtons() {
        BitmapFont font = new BitmapFont();
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.fontColor = Color.WHITE;
        textButtonStyle.font.getData().setScale(5f, 5f);

        TextButton playButton = new TextButton("Play", textButtonStyle);
        TextButton settingsButton = new TextButton("Settings", textButtonStyle);
        TextButton exitButton = new TextButton("Exit", textButtonStyle);

        playButton.addListener(event -> {
            if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
                System.out.println("Play button clicked");
                screen.changeStage(1);
                return true;
            }
            return false;
        });

        settingsButton.addListener(event -> {
            if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
                System.out.println("Settings button clicked");
                return true;
            }
            return false;
        });

        exitButton.addListener(event -> {
            if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
                Gdx.app.exit();
                return true;
          }
            return false;
        });

        table.add(playButton).fillX().uniformX().pad(20);
        table.row().pad(10, 0, 10, 0);
        table.add(settingsButton).fillX().uniformX().pad(20);
        table.row();
        table.add(exitButton).fillX().uniformX().pad(20);
    }
}
