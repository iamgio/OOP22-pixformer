package pixformer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.WorldOptionsFactory;
import pixformer.model.entity.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Physic test for the entity.
 */
final class PhysicTest {

    private static final Vector2D GRAVITY = new Vector2D(0, 0.000_5);
    private static final int PLAYER_SPAWN_Y = 14;
    private static final double DELTA = 0.001;

    private final World world = new WorldImpl(WorldOptionsFactory.testOptions());
    private final Entity entity = new PlayerMock(0, PLAYER_SPAWN_Y, 1, 1);

    @BeforeEach
    void setup() {
        world.spawnEntity(this.entity);
    }

    @Test
    void testDrop() {
        world.update(1);
        assertEquals(GRAVITY.x(), entity.getX());
        assertEquals(PLAYER_SPAWN_Y + GRAVITY.y(), entity.getY(), DELTA);
        world.update(1);
        assertEquals(GRAVITY.x(), entity.getX());
        assertEquals(PLAYER_SPAWN_Y + (3 * GRAVITY.y()), entity.getY(), DELTA);
    }

}
