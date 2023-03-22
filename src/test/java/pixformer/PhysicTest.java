package pixformer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.WorldOptionsFactory;
import pixformer.model.entity.Entity;
import pixformer.model.entity.TestEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhysicTest {

    private static final Vector2D gravity = new Vector2D(0, -0.00008);

    private final World world = new WorldImpl(WorldOptionsFactory.testOptions());
    private Entity entity;

    @BeforeEach
    void setup() {
        this.entity = new TestEntity(0);
        world.spawnEntity(this.entity);
    }

    @Test
    void testDrop() {
        world.update(1);
        assertEquals(gravity.x(), entity.getX());
        assertEquals(15 + gravity.y(), entity.getY(), 0.001);
        world.update(1);
        assertEquals(gravity.x(), entity.getX());
        assertEquals(15 + (3 * gravity.y()), entity.getY(), 0.001);
    }

}
