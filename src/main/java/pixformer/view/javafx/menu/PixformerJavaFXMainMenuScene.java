package pixformer.view.javafx.menu;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import pixformer.controller.Controller;
import pixformer.model.Level;
import pixformer.view.engine.javafx.JavaFXScene;
import pixformer.view.mainmenu.MainMenuView;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * The main menu scene for JavaFX.
 */
public final class PixformerJavaFXMainMenuScene extends JavaFXScene implements MainMenuView {

    private static final double INITIAL_WIDTH = 1200;
    private static final double INITIAL_HEIGHT = 600;

    private static final String STYLESHEET = "/ui/style/menu.css";
    private static final String FONT = "/ui/fonts/MonomaniacOne-Regular.ttf";
    private static final int LOADED_FONT_SIZE = 25;

    private final Set<Consumer<Level>> onLevelSelect = new HashSet<>();

    private final IntegerProperty playersAmount = new SimpleIntegerProperty();

    /**
     * Instantiates a main menu scene.
     * @param controller global controller
     */
    public PixformerJavaFXMainMenuScene(final Controller controller) {
        super(INITIAL_WIDTH, INITIAL_HEIGHT);

        final Scene scene = super.getScene();
        final Pane root = (Pane) scene.getRoot();

        final VBox mainBox = new VBox();
        mainBox.prefWidthProperty().bind(scene.widthProperty());
        mainBox.prefHeightProperty().bind(scene.heightProperty());
        mainBox.setAlignment(Pos.CENTER);

        root.getChildren().add(mainBox);

        Font.loadFont(getClass().getResourceAsStream(FONT), LOADED_FONT_SIZE);
        scene.getStylesheets().add(STYLESHEET);

        final var title = new MainMenuTitle();
        title.prefWidthProperty().bind(mainBox.prefWidthProperty());
        mainBox.getChildren().add(title);

        final var levelsSelector = new MainMenuLevelSelector(controller);
        levelsSelector.prefWidthProperty().bind(mainBox.prefWidthProperty());
        mainBox.getChildren().add(levelsSelector);
        levelsSelector.setOnSelect(file -> this.selectLevel(controller.getLevelFromFile(file)));

        final var playersSelector = new MainMenuPlayersSelector(controller);
        playersSelector.prefWidthProperty().bind(mainBox.prefWidthProperty());
        this.playersAmount.bind(playersSelector.playersAmountProperty());
        mainBox.getChildren().add(playersSelector);

        final var results = new MainMenuScoreResults(controller);
        root.getChildren().add(results);
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
