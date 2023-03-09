package pixformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.Entity;
import pixformer.model.entity.TestEntity;

public class PhysicTest {

    private static final Vector2D gravity = new Vector2D(0, -0.0000011);

    private final World world = new WorldImpl();
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
