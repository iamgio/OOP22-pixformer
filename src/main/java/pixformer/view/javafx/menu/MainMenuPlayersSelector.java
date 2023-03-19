package pixformer.view.javafx.menu;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pixformer.controller.Controller;
import pixformer.view.engine.internationalization.Lang;

/**
 * Controls for adjusting the amount of players.
 */
final class MainMenuPlayersSelector extends VBox {

    private static final int DEFAULT_PLAYERS_AMOUNT = 1;

    private final Controller controller;
    private final IntegerProperty playersAmount = new SimpleIntegerProperty(DEFAULT_PLAYERS_AMOUNT);

    MainMenuPlayersSelector(final Controller controller) {
        this.controller = controller;

        final Lang lang = Lang.getInstance();

        final var title = new Label(lang.get("menu.players"));
        title.getStyleClass().add("players-text");
        title.prefWidthProperty().bind(this.prefWidthProperty());

        final var controlsBox = new HBox();
        controlsBox.getStyleClass().add("players-control");

        final var amount = new Label();
        amount.textProperty().bind(this.playersAmount.asString());
        amount.getStyleClass().add("players-amount");

        final var minus = new Button("-");
        minus.setOnAction(e -> this.setPlayersAmount(this.playersAmount.get() - 1));

        final var plus = new Button("+");
        plus.setOnAction(e -> this.setPlayersAmount(this.playersAmount.get() + 1));

        controlsBox.getChildren().addAll(minus, amount, plus);

        getChildren().addAll(title, controlsBox);
    }

    private void setPlayersAmount(final int playersAmount) {
        this.playersAmount.setValue(controller.correctSupportedPlayersAmount(playersAmount));
    }

    IntegerProperty playersAmountProperty() {
        return this.playersAmount;
    }
}
