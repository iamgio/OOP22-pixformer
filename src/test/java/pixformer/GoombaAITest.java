package pixformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.BoundingBox;
import pixformer.model.entity.collision.RectangleBoundingBox;
import pixformer.model.entity.dynamic.Enemy;
import pixformer.model.entity.dynamic.ai.GoombaAI;
import pixformer.model.entity.statics.Block;
import pixformer.model.input.InputComponent;

final class GoombaAITest {

    private static final double X_BLOCK = -2;
    private static final double DELTA = 0.0001;
    private final World world = new WorldImpl();
    // private final Enemy goomba = new Enemy(0, 0, 1, 1, step);
    private final Entity goomba = new AbstractEntity(0, 0, 1, 1) {

        private final Optional<InputComponent> ai = Optional.of(new GoombaAI(this, this::setVelocity, step));

        @Override
        public BoundingBox getBoundingBox() {
            return new RectangleBoundingBox(getWidth(), getHeight());
        }

        @Override
        public Optional<InputComponent> getInputComponent() {
            return ai;
        }
        
    };
    private static final double step = 0.002;
    private static final double dt = 1;

    @BeforeEach
    void setup() {
        world.spawnEntity(goomba);
    }

    @Test
    void testClearRoad() {
        final double numberOfSteps = 2;
        world.update(dt);
        assertEquals(-step, goomba.getX());
        assertEquals(0, goomba.getY());
        world.update(dt);
        assertEquals(-numberOfSteps * step, goomba.getX());
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
            assertEquals(0, goomba.getY(), DELTA);
            world.update(dt);
        }
        world.update(dt);
        assertEquals(finalPosition, goomba.getX(), DELTA);
        assertEquals(0, goomba.getY(), DELTA);
    }
}
