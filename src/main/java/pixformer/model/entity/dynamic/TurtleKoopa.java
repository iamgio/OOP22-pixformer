package pixformer.model.entity.dynamic;

import java.util.Optional;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.input.InputComponent;

/**
 * The state of the koopa when it is a turtle.
 */
public final class TurtleKoopa extends AbstractEntity implements KoopaState, DefaultRectangleBoundingBoxEntity {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    private final InputComponent inputComponent;

    /**
     * Create a new TurtleKoopa.
     * 
     * @param x its initial x position
     * @param y its initial y position.
     */
    public TurtleKoopa(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
        inputComponent = new TurtleKoopaInputComponent(this);
    }

    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return ActionOnPressedCollisionComponent.createWithWorldFromEntityForDying(this);
    }

    @Override
    public boolean isWalking() {
        return false;
    }

    @Override
    public Optional<InputComponent> getInputComponent() {
        return Optional.of(inputComponent);
    }

}
