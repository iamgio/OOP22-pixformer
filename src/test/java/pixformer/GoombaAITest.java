package pixformer;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.dynamic.Goomba;
import pixformer.model.entity.statics.Block;

final class GoombaAITest {

    private static final double DELTA = 0.0001;
    private final World world = new WorldImpl();
    private Goomba goomba;
    private final double step = -0.002;
    private final double dt = 1;

    @BeforeEach
    void setup() {
        goomba = new Goomba(0, 0);
        world.spawnEntity(goomba);
    }

    @Test
    void testClearRoad() {
        world.update(dt);
        assertEquals(step, goomba.getX());
        assertEquals(0, goomba.getY());
        world.update(dt);
        assertEquals(2 * step, goomba.getX());
        assertEquals(0, goomba.getY());
    }

    @Test
    void testFindObstacle() {
        world.spawnEntity(new Block(-2, 0)); // x_y
        for (double i = 0; i > -1; i += step) {
            assertEquals(i, goomba.getX());
            assertEquals(0, goomba.getY());
            world.update(dt);
        }
        world.update(dt);
        assertEquals(-1 - step, goomba.getX(), DELTA);
        assertEquals(0, goomba.getY());
    }
}
