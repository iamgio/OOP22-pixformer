package pixformer;

import pixformer.view.ViewLauncher;
import pixformer.view.javafx.JavaFXViewLauncher;

/**
 * The main class.
 */
public class Pixformer {

    public static void main(String[] args) {
        ViewLauncher launcher = new JavaFXViewLauncher();
        launcher.launch();
    }
}