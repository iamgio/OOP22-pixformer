package pixformer.view.javafx.menu;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import pixformer.common.file.FileUtils;
import pixformer.controller.Controller;
import pixformer.view.engine.internationalization.Lang;

import java.io.File;
import java.util.function.Consumer;

/**
 * Level selector for the main menu.
 */
final class MainMenuLevelSelector extends VBox {

    private Consumer<File> onSelect;

    MainMenuLevelSelector(final Controller controller) {
        final Lang lang = Lang.getInstance();

        final var title = new Label(lang.get("menu.levels"));
        title.getStyleClass().add("levels-text");
        title.prefWidthProperty().bind(this.prefWidthProperty());

        final var levelsBox = new FlowPane(Orientation.HORIZONTAL);
        levelsBox.getStyleClass().add("levels-box");

        controller.getLevelFiles().stream()
                .map(this::createLevelButton)
                .forEach(levelsBox.getChildren()::add);

        getChildren().addAll(title, levelsBox);
    }

    private Button createLevelButton(final File levelFile) {
        final String name = FileUtils.getNameWithoutExtension(levelFile);
        final var button = new Button(name);
        button.getStyleClass().add("level-button");

        button.setOnMouseClicked(e -> {
            if (this.onSelect != null) {
                this.onSelect.accept(levelFile);
            }
        });

        return button;
    }

    /**
     * Adds an action to run when a level file is selected.
     * @param action action to run, with the level file as an argument
     */
    public void setOnSelect(final Consumer<File> action) {
        this.onSelect = action;
    }
}
