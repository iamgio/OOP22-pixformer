package pixformer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.statics.Block;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollisionsTest {

    private static class TestEntity extends AbstractEntity implements DefaultRectangleBoundingBoxEntity {

        private static final int WIDTH = 2;
        private static final int HEIGHT = 2;

        public TestEntity(final double x, final double y) {
            super(x, y, WIDTH, HEIGHT);
        }
    }

    private World world;
    private AbstractEntity entity;

    @BeforeEach
    void setup() {
        this.world = new WorldImpl();
        this.entity = new TestEntity(0, 0);
        world.spawnEntity(entity);
    }

    private void entityForward() {
        entity.setX(entity.getX() + 1);
    }

    private void blockBackward() {
        entity.setX(entity.getX() + 1);
    }

    private Set<Collision> getCollisions() {
        return world.getCollisionManager().findCollisionsFor(entity);
    }

    @Test
    void testIdleCollision() {
        // Initial: xx_y__ (x = entity, y = block, _ = empty)
        assertEquals(0, getCollisions().size());
        world.spawnEntity(new Block(3, 0));
        assertEquals(0, getCollisions().size());
        entityForward(); // xxy__
        assertEquals(1, getCollisions().size());
        entityForward(); // _xy__
        assertEquals(1, getCollisions().size());
        entityForward(); // __yx__
        assertEquals(1, getCollisions().size());
        entityForward(); // __yxx_
        assertEquals(1, getCollisions().size());
        entityForward(); // __y_xx
        assertEquals(0, getCollisions().size());
    }
}
