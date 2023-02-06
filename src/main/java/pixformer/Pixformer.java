package pixformer;

import pixformer.view.engine.ViewLauncher;
import pixformer.view.javafx.PixformerJavaFXViewLauncher;

/**
 * The main class.
 */
public final class Pixformer {

    private Pixformer() {

    }

    /**
     * Main method to launch the application.
     * @param args
     */
    public static void main(final String[] args) {
        ViewLauncher launcher = new PixformerJavaFXViewLauncher();
        launcher.launch();
    }
}
