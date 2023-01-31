package pixformer.view;

import pixformer.controller.InputType;
import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.TextRenderer;

import java.util.Date;
import java.util.Set;

/**
 * Implementation of the standard game view.
 */
public class ViewImpl implements View {

    private final GameScene scene;

    private TextRenderer text;

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
        text.setColor(new Color(1, .8, 0));
        text.setFontSize(30);
        scene.add(text.at(100, 100));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<InputType> getInputs() {
        return this.scene.getInputs();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        this.text.setText("Now:\n" + new Date() + "\nInputs: " + scene.getInputs().toString());
        this.scene.render();
    }
}
