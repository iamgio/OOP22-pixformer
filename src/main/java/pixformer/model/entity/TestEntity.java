package pixformer.model.entity;

import pixformer.model.World;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.input.InputComponent;
import pixformer.view.entity.TestGraphicsComponent;

import java.util.Optional;

/**
 * @deprecated test
 */
@Deprecated
public class TestEntity extends AbstractEntity implements DrawableEntity, DefaultRectangleBoundingBoxEntity {

    private static final double SIZE = 1; // Test values

    private boolean hasCollided = false;

    private final InputComponent inputComponent;
    private final GraphicsComponent graphicsComponent;

    /**
     * @param x X coordinate
     */
    public TestEntity(final double x) {
        super(x, 15, SIZE, SIZE);
        this.inputComponent = new TestInputComponent(this);
        this.graphicsComponent = new TestGraphicsComponent(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSpawn(final World world) {
        world.getCollisionManager().addOnCollide(this, other -> hasCollided = true);
    }

    @Override
    public Optional<InputComponent> getInputComponent() {
        return Optional.of(inputComponent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return this.graphicsComponent;
    }

    /**
     * @return whether this entity has collided with another entity
     */
    public boolean hasCollided() {
        return this.hasCollided;
    }
}
