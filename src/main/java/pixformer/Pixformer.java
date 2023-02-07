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
     * @param args program arguments
     */
    public static void main(final String[] args) {
        final ViewLauncher launcher = new PixformerJavaFXViewLauncher();
        launcher.launch();
    }
}
