package pixformer.view.javafx.menu;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pixformer.view.engine.internationalization.Lang;

/**
 *
 */
class MainMenuTitle extends VBox {

    MainMenuTitle() {
        final Lang lang = Lang.getInstance();

        final var title = new Label(lang.get("menu.title"));
        title.getStyleClass().add("title");

        final var subtitle = new Label(lang.get("menu.subtitle"));
        title.getStyleClass().add("subtitle");

        getChildren().addAll(title, subtitle);
    }
}
