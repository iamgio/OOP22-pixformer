package pixformer.controller;

import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.TextRenderer;

/**
 * The default game loop.
 */
public class DefaultGameLoop implements GameLoop {

    private final GameScene scene;

    private final TextRenderer text;

    /**
     * Creates the default game loop that relies on a visual renderable scene.
     * @param scene active game scene
     */
    public DefaultGameLoop(GameScene scene) {
        this.scene = scene;

        // This is a test: graphics shouldn't be here, but somewhere in the view.
        RendererFactory rendererFactory = scene.getRendererFactory();

        scene.add(rendererFactory.newSolidBackground(Color.BLACK));

        this.text = rendererFactory.newText("");
        text.setColor(new Color(1, .8, 0));
        text.setFontSize(30);
        scene.add(text.at(100, 100));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void loop(long now) {
        // Debug view

        text.setText("Now:\n" + (now / 1000) + "\nInputs: " + scene.getInputs().toString());

        scene.render();
    }
}
