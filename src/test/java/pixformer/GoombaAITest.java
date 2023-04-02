package pixformer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.WorldOptionsFactory;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.Entity;
import pixformer.model.entity.EntityFactory;
import pixformer.model.entity.EntityFactoryImpl;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.BoundingBox;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.RectangleBoundingBox;
import pixformer.model.entity.collision.SolidCollisionComponent;
import pixformer.model.entity.dynamic.enemy.ai.GoombaInputComponent;
import pixformer.model.input.InputComponent;
import pixformer.view.entity.SpritesGraphicsComponentFactory;

import java.util.Optional;
import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

final class GoombaAITest {

    private static final double X_BLOCK = -2;
    private static final double DELTA = 0.0001;
    private static final double STEP = 0.002;
    private static final double DT = 1;
    private final World world = new WorldImpl(WorldOptionsFactory.testOptions());
    private EntityFactory entityFactory = new EntityFactoryImpl(new SpritesGraphicsComponentFactory(), world);
    private Entity goomba;
    private final Function<Vector2D, MutableEntity> goombaFactory = v -> new AbstractEntity(v.x(), v.y(), 1, 1) {

        private final Optional<InputComponent> ai = Optional.of(new GoombaInputComponent(this));

        @Override
        public BoundingBox getBoundingBox() {
            return new RectangleBoundingBox(getWidth(), getHeight());
        }

        @Override
        public Optional<InputComponent> getInputComponent() {
            return ai;
        }

        @Override
        public Optional<CollisionComponent> getCollisionComponent() {
            return Optional.of(new SolidCollisionComponent(this));
        }
    };

    @BeforeEach
    void setup() {
        goomba = goombaFactory.apply(new Vector2D(0, 0));
        world.spawnEntity(goomba);
        this.entityFactory = new EntityFactoryImpl(new SpritesGraphicsComponentFactory(), world);
    }

    @Test
    void testClearRoad() {
        final double numberOfSteps = 2;
        world.update(DT);
        assertEquals(-STEP, goomba.getX());
        assertEquals(0, goomba.getY());
        world.update(DT);
        assertEquals(-numberOfSteps * STEP, goomba.getX());
        assertEquals(0, goomba.getY());
    }

    @Test
    void testFindObstacle() {
        world.spawnEntity(this.entityFactory.createTileBlock((int) X_BLOCK, 0)); // -2, -1
        world.spawnEntity(this.entityFactory.createTileBlock(2, 0)); // 1, 2
        goUntil(0, i -> i > -1, i -> i - STEP, -1 + STEP);
        goUntil(-1 + STEP, i -> i < 1, i -> i + STEP, 1 - STEP);
        // for (double i = -1 + step; i < 1; i += step) {
        // assertEquals(i, goomba.getX(), DELTA);
        // assertEquals(0, goomba.getY());
        // world.update(dt);
        // }
        // world.update(dt);
        // assertEquals(1 - step, goomba.getX(), DELTA);
        // assertEquals(0, goomba.getY());
    }

    @Test
    void testFallAndMove() {
        final int goombaInitialY = -200;
        final int goombaFinalY = -1;
        final int initialYVelocity = 1;
        final int floorHeight = 0;
        createFloor(floorHeight);
        final MutableEntity goomba = goombaFactory.apply(new Vector2D(0, goombaInitialY));
        goomba.setVelocity(new Vector2D(0, initialYVelocity));
        world.spawnEntity(goomba);
        for (int i = goombaInitialY; i < goombaFinalY; i++) {
            world.update(DT);
        }
        assertTrue(goomba.getVelocity().x() < 0);
        assertEquals(goombaFinalY, goomba.getY(), DELTA);
    }

    private void createFloor(final int height) {
        final int width = 1000;
        for (int i = 0; i < width; i++) {
            world.spawnEntity(this.entityFactory.createTileBlock(i, height));
        }
    }

    private void goUntil(
            final double start,
            final DoublePredicate hasNext,
            final DoubleUnaryOperator next,
            final double finalPosition) {
        for (double i = start; hasNext.test(i); i = next.applyAsDouble(i)) {
            assertEquals(i, goomba.getX(), DELTA);
            assertEquals(0, goomba.getY(), DELTA);
            world.update(DT);
        }
        world.update(DT);
        assertEquals(finalPosition, goomba.getX(), DELTA);
        assertEquals(0, goomba.getY(), DELTA);
    }
}
