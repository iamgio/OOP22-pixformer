package pixformer;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pixformer.view.engine.Color;
import pixformer.view.engine.RectangleRenderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.TextRenderer;
import pixformer.view.engine.javafx.JavaFXImageRenderer;
import pixformer.view.engine.javafx.JavaFXScene;

/**
 * Test for the rendering architecture.
 */
public class RenderingTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        JavaFXScene scene = new JavaFXScene(600, 500);
        RendererFactory factory = scene.getRendererFactory();

        scene.add(factory.newSolidBackground(new Color(.4, .3, .6)));
        scene.add(new JavaFXImageRenderer(new Image("https://dev.java/assets/images/java-logo-vert-blk.png"))); // TODO add to factory

        TextRenderer text = factory.newText("Test");
        text.setColor(Color.WHITE);
        text.setFontFamily("Monospaced");
        scene.add(text.at(100, 100));

        RectangleRenderer rectangle = factory.newRectangle(300, 200);
        rectangle.setColor(new Color(.8, .5, .5));
        scene.add(rectangle.at(400, 400));
        scene.render();

        primaryStage.setScene(scene.getScene());
        primaryStage.show();
    }
}
