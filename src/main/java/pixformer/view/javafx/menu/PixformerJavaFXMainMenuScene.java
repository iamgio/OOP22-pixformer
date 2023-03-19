package pixformer.view.javafx.menu;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import pixformer.controller.Controller;
import pixformer.model.Level;
import pixformer.model.LevelMock;
import pixformer.view.engine.javafx.JavaFXScene;
import pixformer.view.mainmenu.MainMenuView;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * The main menu scene for JavaFX.
 */
public class PixformerJavaFXMainMenuScene extends JavaFXScene implements MainMenuView {

    private static final double INITIAL_WIDTH = 1200;
    private static final double INITIAL_HEIGHT = 600;
    private static final int DEFAULT_PLAYERS_AMOUNT = 1;

    private static final String STYLESHEET = "/ui/style/menu.css";
    private static final String FONT = "/ui/fonts/MonomaniacOne-Regular.ttf";

    private final Controller controller;
    private final Set<Consumer<Level>> onLevelSelect = new HashSet<>();

    private final IntegerProperty playersAmount = new SimpleIntegerProperty(DEFAULT_PLAYERS_AMOUNT);

    /**
     * Instantiates a main menu scene.
     * @param controller global controller
     */
    public PixformerJavaFXMainMenuScene(final Controller controller) {
        super(INITIAL_WIDTH, INITIAL_HEIGHT);
        this.controller = controller;

        Scene scene = super.getScene();
        Pane root = (Pane) scene.getRoot();

        Font.loadFont(getClass().getResourceAsStream(FONT), 20);
        scene.getStylesheets().add(STYLESHEET);

        root.getChildren().add(new MainMenuTitle());

        // Here the level will be retrieved from a button, or something...
        root.setOnMouseClicked(e -> this.selectLevel(new LevelMock()));

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP -> this.setPlayersAmount(this.playersAmount.get() + 1);
                case DOWN -> this.setPlayersAmount(this.playersAmount.get() - 1);
                default -> {
                    // Required by the linter
                }
            }
        });
    }

    private void setPlayersAmount(final int playersAmount) {
        this.playersAmount.setValue(controller.correctSupportedPlayersAmount(playersAmount));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPlayersAmount() {
        return this.playersAmount.get();
    }

    private void selectLevel(final Level level) {
        this.onLevelSelect.forEach(action -> action.accept(level));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOnLevelSelect(final Consumer<Level> action) {
        this.onLevelSelect.add(action);
    }
}
