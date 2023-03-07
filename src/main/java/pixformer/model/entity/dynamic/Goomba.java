package pixformer.model.entity.dynamic;

import java.util.Optional;

import pixformer.common.Vector2D;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.dynamic.ai.GoombaAI;
import pixformer.model.input.InputComponent;
/**
 * The default implementation of a goomba.
 */
public class Goomba extends AbstractEntity implements DefaultRectangleBoundingBoxEntity {

    private static final int WIDTH = 1;
    private static final int HEIGHT = 1;
    private static final Vector2D INITIAL_VELOCITY = new Vector2D(-0.04, 0);
    private final GoombaAI ai;

    /**
     * Create a Goomba at position ({@code x}, {@code y}).
     * @param x coordinate
     * @param y coordinate.
     */
    public Goomba(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
        setVelocity(INITIAL_VELOCITY);
        ai = new GoombaAI(this);
    }

    @Override
    public final Optional<InputComponent> getInputComponent() {
        return Optional.of(ai);
    }
    
}
