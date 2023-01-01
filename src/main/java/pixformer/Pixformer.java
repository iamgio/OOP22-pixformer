package pixformer;

import pixformer.view.engine.ViewLauncher;
import pixformer.view.javafx.PixformerJavaFXViewLauncher;

/**
 * The main class.
 */
public class Pixformer {

    public static void main(String[] args) {
        ViewLauncher launcher = new PixformerJavaFXViewLauncher();
        launcher.launch();
    }
}