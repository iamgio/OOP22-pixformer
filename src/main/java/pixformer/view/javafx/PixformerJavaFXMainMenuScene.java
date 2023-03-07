package pixformer.view.javafx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import pixformer.common.wrap.SimpleWrapper;
import pixformer.common.wrap.Wrapper;
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

    private final Wrapper<Controller> controller;
    private final Set<Consumer<Level>> onLevelSelect = new HashSet<>();

    private final IntegerProperty playersAmount = new SimpleIntegerProperty();

    /**
     * Instantiates a main menu scene.
     * @param controller global controller
     */
    public PixformerJavaFXMainMenuScene(final Controller controller) {
        super(INITIAL_WIDTH, INITIAL_HEIGHT);
        this.controller = new SimpleWrapper<>(controller);
        this.setPlayersAmount(controller.getPlayersAmount());

        Scene scene = super.getScene();
        Pane root = (Pane) scene.getRoot();

        root.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));

        var text = new Label();
        text.textProperty().bind(
                new SimpleStringProperty("Click to start\nPlayers: ").concat(this.playersAmount.asString())
        );
        text.setTextFill(Color.WHITE);
        root.getChildren().add(text);

        // Here the level will be retrieved from a button, or something...
        root.setOnMouseClicked(e -> this.selectLevel(new LevelMock()));

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP -> this.setPlayersAmount(controller.getPlayersAmount() + 1);
                case DOWN -> this.setPlayersAmount(controller.getPlayersAmount() - 1);
                default -> {
                    // Required by the linter
                }
            }
        });
    }

    private void setPlayersAmount(final int playersAmount) {
        this.controller.unwrap(controller -> {
            controller.setPlayersAmount(playersAmount);
            this.playersAmount.set(controller.getPlayersAmount());
        });
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
