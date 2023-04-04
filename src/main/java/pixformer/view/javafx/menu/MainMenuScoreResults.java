package pixformer.view.javafx.menu;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pixformer.controller.Controller;
import pixformer.view.engine.internationalization.Lang;

/**
 * Player scoreboard for the main menu
 */
final class MainMenuScoreResults extends VBox {

    MainMenuScoreResults(final Controller controller) {
        getStyleClass().add("score");

        if (controller.getIndexedLeaderboard().isEmpty()) {
            return;
        }

        final var title = new Label(Lang.getInstance().get("menu.leaderboard.score.title"));
        title.getStyleClass().add("score-title");
        getChildren().add(title);

        for (final int playerIndex : controller.getIndexedLeaderboard()) {
            final var text = Lang.getInstance().get("menu.leaderboard.score.entry")
                    .replace("{i}", String.valueOf(playerIndex + 1))
                    .replace("{p}", String.valueOf(controller.getPlayerPointsByIndex(playerIndex)));

            final var label = new Label(text);
            label.getStyleClass().add("score-entry");
            getChildren().add(label);
        }
    }
}
