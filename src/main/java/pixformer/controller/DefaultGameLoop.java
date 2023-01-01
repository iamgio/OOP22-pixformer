package pixformer.controller;

import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.TextBuilder;

/**
 * The default game loop.
 */
public class DefaultGameLoop implements GameLoop {

    private final GameScene scene;

    /**
     * Creates the default game loop that relies on a visual renderable scene.
     * @param scene active game scene
     */
    public DefaultGameLoop(GameScene scene) {
        this.scene = scene;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void loop(long now) {
        // Debug view

        RendererFactory rendererFactory = scene.getRendererFactory();
        scene.add(rendererFactory.newSolidBackground(Color.BLACK));
        scene.add(new TextBuilder("Now:\n" + (now / 1000)).withColor(Color.WHITE).build(rendererFactory).at(100, 100));

        scene.render();
        System.out.println(now);
    }
}
