package pixformer.view.javafx;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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

    private final Set<Consumer<Level>> onLevelSelect = new HashSet<>();

    /**
     * Instantiates a main menu scene.
     */
    public PixformerJavaFXMainMenuScene() {
        super(INITIAL_WIDTH, INITIAL_HEIGHT);

        Scene scene = super.getScene();
        Pane root = (Pane) scene.getRoot();

        root.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));

        var label = new Label("Click to start");
        label.setTextFill(Color.WHITE);
        root.getChildren().add(label);

        // Here the level will be retrieved from a button, or something...
        root.setOnMouseClicked(e -> this.selectLevel(new LevelMock()));
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
