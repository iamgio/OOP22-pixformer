package pixformer.view.javafx.menu;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pixformer.view.engine.internationalization.Lang;

/**
 * Title and subtitle texts for the main menu.
 */
class MainMenuTitle extends VBox {

    MainMenuTitle() {
        final Lang lang = Lang.getInstance();

        final var title = new Label(lang.get("menu.title"));
        title.getStyleClass().add("title");
        title.prefWidthProperty().bind(this.prefWidthProperty());

        final var subtitle = new Label(lang.get("menu.subtitle"));
        subtitle.getStyleClass().add("subtitle");
        subtitle.prefWidthProperty().bind(this.prefWidthProperty());

        getChildren().addAll(title, subtitle);
    }
}
