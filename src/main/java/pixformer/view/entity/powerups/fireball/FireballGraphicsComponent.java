package pixformer.view.entity.powerups.fireball;

import java.util.List;

import pixformer.model.entity.powerup.other.fireball.Fireball;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.CachedAnimatedGraphicsComponent;

/**
 * Implementation of a GraphicsCopmponent for a Fireball entity.
 */
public class FireballGraphicsComponent extends CachedAnimatedGraphicsComponent {
    private static final long SWITCH_TIME = 200;

    /**
     * @param fireball Entity that will be displayed.
     */
    public FireballGraphicsComponent(final Fireball fireball) {
        super(fireball, SWITCH_TIME);
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    protected List<Renderer> createRenderers(final RendererFactory factory) {
        return List.of(
            factory.newImage("/sprites/player/powerups/other/fireball/fireball_1.png",
             getEntity().getWidth(), getEntity().getHeight()),
            factory.newImage("/sprites/player/powerups/other/fireball/fireball_2.png",
             getEntity().getWidth(), getEntity().getHeight()),
            factory.newImage("/sprites/player/powerups/other/fireball/fireball_3.png",
             getEntity().getWidth(), getEntity().getHeight())
        );
    }

}
