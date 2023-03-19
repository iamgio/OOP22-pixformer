package pixformer.view.javafx.menu;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import pixformer.controller.Controller;
import pixformer.view.engine.internationalization.Lang;

/**
 * Level selector for the main menu.
 */
final class MainMenuLevelSelector extends VBox {

    private final Controller controller;

    MainMenuLevelSelector(final Controller controller) {
        this.controller = controller;

        final Lang lang = Lang.getInstance();

        final var title = new Label(lang.get("menu.levels"));
        title.getStyleClass().add("levels-text");
        title.prefWidthProperty().bind(this.prefWidthProperty());

        final var levelsBox = new FlowPane(Orientation.HORIZONTAL);
        levelsBox.getStyleClass().add("levels-box");

        levelsBox.getChildren().add(createLevelButton("Test level 1"));
        levelsBox.getChildren().add(createLevelButton("Test level 2"));

        getChildren().addAll(title, levelsBox);
    }

    private Button createLevelButton(String name) {
        final var button = new Button(name);
        button.getStyleClass().add("level-button");
        return button;
    }
}
