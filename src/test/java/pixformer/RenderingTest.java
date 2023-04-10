package pixformer;

import javafx.application.Application;
import javafx.stage.Stage;
import pixformer.view.engine.Color;
import pixformer.view.engine.RectangleRenderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.TextRenderer;
import pixformer.view.engine.javafx.JavaFXScene;

/**
 * Test for the rendering architecture.
 */
public final class RenderingTest extends Application {

    private static final double SCENE_WIDTH = 600;
    private static final double SCENE_HEIGHT = 500;
    private static final Color BG_COLOR = new Color(.4, .3, .6);

    private static final double TEXT_X = 200;
    private static final double TEXT_Y = 100;

    private static final double RECTANGLE_WIDTH = 300;
    private static final double RECTANGLE_X = 400;
    private static final double RECTANGLE_Y = 400;
    private static final double RECTANGLE_HEIGHT = 200;

    private static final double IMAGE_WIDTH = 150;
    private static final double IMAGE_HEIGHT = 150;
    private static final Color RECTANGLE_COLOR = new Color(.8, .5, .5);

    @Override
    public void start(final Stage primaryStage) {
        final JavaFXScene scene = new JavaFXScene(SCENE_WIDTH, SCENE_HEIGHT);
        final RendererFactory factory = scene.getRendererFactory();

        scene.add(factory.newSolidBackground(BG_COLOR));
        scene.add(factory.newImage("/sprites/player/mario_small_idle.png", IMAGE_WIDTH, IMAGE_HEIGHT));

        final TextRenderer text = factory.newText("Test");
        text.setColor(Color.WHITE);
        text.setFontFamily("Monospaced");
        scene.add(text.at(TEXT_X, TEXT_Y));

        final RectangleRenderer rectangle = factory.newRectangle(RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
        rectangle.setColor(RECTANGLE_COLOR);
        scene.add(rectangle.at(RECTANGLE_X, RECTANGLE_Y));
        scene.render();

        primaryStage.setScene(scene.getScene());
        primaryStage.show();
    }
}
