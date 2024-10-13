package Game.game.menuStage;

import Game.game.gameScreen.GameScreen;
import com.badlogic.gdx.Gdx;
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

import Game.game.gameAssets.MapManager;

@SuppressWarnings("unused")
public class MenuStage extends Stage {

    private Image backgroundImage;
    private static final int STAGE_INDEX = 3;
    private OrthographicCamera ortho;
    private BitmapFont font;
    private SpriteBatch batch;
    private GameScreen screen;
    private Table table;

    public MenuStage(GameScreen screen) {
        super(new ScreenViewport());

        Gdx.input.setInputProcessor(this);

        ortho = new OrthographicCamera();
        ortho.setToOrtho(false, 1280, 736);

        table = new Table();
        table.setFillParent(true);
        this.addActor(table);

        this.screen = screen;

        createBackground();
        createButtons();
    }

    private void createBackground() {
        Texture backgroundTexture = new Texture(Gdx.files.internal("MenuBackground.jpg"));
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        table.setBackground(backgroundImage.getDrawable());
    }
    private void createButtons() {
        BitmapFont font = new BitmapFont();
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.fontColor = Color.WHITE;
        textButtonStyle.font.getData().setScale(3, 3);

        TextButton playButton = new TextButton("Jogar", textButtonStyle);
        TextButton settingsButton = new TextButton("Configurações", textButtonStyle);
        TextButton exitButton = new TextButton("Sair", textButtonStyle);

        playButton.addListener(event -> {
            if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
                System.out.println("Play button clicked");
                screen.changeStage(0);
                return true;
            }
            return false;
        });

        settingsButton.addListener(event -> {
            if (event instanceof InputEvent && ((InputEvent) event).getType() == InputEvent.Type.touchDown) {
                System.out.println("Settings button clicked");
                screen.changeStage(2);
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
