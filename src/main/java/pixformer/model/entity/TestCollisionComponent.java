package pixformer.model.entity;

import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;

import java.util.Set;

/**
 * Collision component for the test entity.
 * @deprecated test
 */
@Deprecated
public class TestCollisionComponent extends CollisionComponent {

    private final TestEntity testEntity;

    /**
     * @param testEntity entity
     */
    public TestCollisionComponent(final TestEntity testEntity) {
        super(testEntity);
        this.testEntity = testEntity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        if (!collisions.isEmpty()) {
            this.testEntity.setHasCollided(true);
        }
    }
}
