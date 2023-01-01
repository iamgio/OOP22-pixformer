package pixformer;

import pixformer.view.engine.ViewLauncher;
import pixformer.view.engine.javafx.JavaFXViewLauncher;

/**
 * The main class.
 */
public class Pixformer {

    public static void main(String[] args) {
        ViewLauncher launcher = new JavaFXViewLauncher();
        launcher.launch();
    }
}