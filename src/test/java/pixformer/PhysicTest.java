package pixformer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.WorldOptionsFactory;
import pixformer.model.entity.Entity;
import pixformer.model.entity.dynamic.player.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Physic test for the entity.
 */
public final class PhysicTest {

    private static final Vector2D GRAVITY = new Vector2D(0, 0.00008);
    private static final int PLAYER_SPAWN_Y = 14;
    private static final double DELTA = 0.001;

    private final World world = new WorldImpl(WorldOptionsFactory.testOptions());
    private Entity entity;

    @BeforeEach
    void setup() {
        this.entity = new Player(0, PLAYER_SPAWN_Y, 1, 1, 0);
        world.spawnEntity(this.entity);
    }

    @Test
    void testDrop() {
        world.update(1);
        assertEquals(GRAVITY.x(), entity.getX());
        assertEquals(PLAYER_SPAWN_Y + 1 + GRAVITY.y(), entity.getY(), DELTA);
        world.update(1);
        assertEquals(GRAVITY.x(), entity.getX());
        assertEquals(PLAYER_SPAWN_Y + 1 + (3 * GRAVITY.y()), entity.getY(), DELTA);
    }

}
