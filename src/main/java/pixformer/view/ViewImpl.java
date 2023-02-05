package pixformer.view;

import pixformer.controller.InputType;
import pixformer.controller.ObservableInputPolling;
import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.TextRenderer;

import java.util.Date;

/**
 * Implementation of the standard game view.
 */
public class ViewImpl implements View {

    private final GameScene scene;

    private TextRenderer text;

    /**
     * Initializes the default view.
     * @param scene current game scene
     */
    public ViewImpl(final GameScene scene) {
        this.scene = scene;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setup() {
        RendererFactory rendererFactory = scene.getRendererFactory();

        scene.add(rendererFactory.newSolidBackground(Color.BLACK));

        this.text = rendererFactory.newText("");
        text.setColor(new Color(1, 0, 0));
        scene.add(text.at(100, 100));

        // Test
        scene.getInputPolling().addAction(InputType.P1_JUMP, () -> this.text.setText("Jumping"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObservableInputPolling getInputPolling() {
        return this.scene.getInputPolling();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        this.text.setText("Now:\n" + new Date());

        this.getInputPolling().update(dt);
        this.scene.render();
    }
}
