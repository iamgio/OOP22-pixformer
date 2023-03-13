package pixformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.dynamic.Enemy;
import pixformer.model.entity.statics.Block;

final class GoombaAITest {

    private static final double X_BLOCK = -2;
    private static final double DELTA = 0.0001;
    private final World world = new WorldImpl();
    private Enemy goomba;
    private final double step = 0.002;
    private final double dt = 1;

    @BeforeEach
    void setup() {
        goomba = new Enemy(0, 0, 1, 1, step);
        world.spawnEntity(goomba);
    }

    @Test
    void testClearRoad() {
        world.update(dt);
        assertEquals(-step, goomba.getX());
        assertEquals(0, goomba.getY());
        world.update(dt);
        assertEquals(-2 * step, goomba.getX());
        assertEquals(0, goomba.getY());
    }

    @Test
    void testFindObstacle() {
        world.spawnEntity(new Block(X_BLOCK, 0)); // -2, -1
        world.spawnEntity(new Block(2, 0)); // 1, 2
        goUntil(0, i -> i > -1, i -> i - step, -1 + step);
        goUntil(-1 + step, i -> i < 1, i -> i + step, 1 - step);
        // for (double i = -1 + step; i < 1; i += step) {
        // assertEquals(i, goomba.getX(), DELTA);
        // assertEquals(0, goomba.getY());
        // world.update(dt);
        // }
        // world.update(dt);
        // assertEquals(1 - step, goomba.getX(), DELTA);
        // assertEquals(0, goomba.getY());
    }

    private void goUntil(
            final double start,
            final DoublePredicate hasNext,
            final DoubleUnaryOperator next,
            final double finalPosition) {
        for (double i = start; hasNext.test(i); i = next.applyAsDouble(i)) {
            assertEquals(i, goomba.getX(), DELTA);
            assertEquals(0, goomba.getY());
            world.update(dt);
        }
        world.update(dt);
        assertEquals(finalPosition, goomba.getX(), DELTA);
        assertEquals(0, goomba.getY());
    }
}
