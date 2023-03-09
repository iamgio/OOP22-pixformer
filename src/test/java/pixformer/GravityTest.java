package pixformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.TestEntity;
import pixformer.model.entity.dynamic.Goomba;

public class GravityTest {

    private final World world = new WorldImpl();
    private TestEntity entity;

    @BeforeEach
    void setup() {
        this.entity = new TestEntity(0);
    }

    @Test
    void testDrop() {
        world.update(1);
        assertEquals(0, entity.getX());
        assertEquals(1, entity.getY());
        world.update(1);
        assertEquals(0, entity.getX());
        assertEquals(2, entity.getY());
    }

}
