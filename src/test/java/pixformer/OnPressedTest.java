package pixformer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.WorldOptionsFactory;
import pixformer.model.entity.Entity;
import pixformer.model.entity.EntityFactory;
import pixformer.model.entity.EntityFactoryImpl;
import pixformer.model.entity.dynamic.enemy.koopa.KoopaState;
import pixformer.model.entity.dynamic.enemy.koopa.turtle.TurtleKoopa;
import pixformer.model.entity.dynamic.enemy.koopa.walking.WalkingKoopa;
import pixformer.view.entity.NullGraphicsComponentFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests to check if the
 * {@link pixformer.model.entity.dynamic.reactor.ActionOnPressedCollisionReactor}
 * works.
 */
final class OnPressedTest {

    private static final int SECONDS_TO_MILLIS = 1_000;
    private static final int FPS = 30;
    private static final double DT = (double) SECONDS_TO_MILLIS / FPS * 30;
    private World world;
    private EntityFactory factory;

    @BeforeEach
    void setup() {
        world = new WorldImpl(WorldOptionsFactory.testOptions());
        factory = new EntityFactoryImpl(new NullGraphicsComponentFactory(), world);
    }

    private World createPrisonAndFallingPlayer(final Entity entity) {
        /*
         * p
         * p
         * #g#
         * #
         */
        Set.of(
                entity,
                new PlayerMock(0, 0, 1, 2),
                factory.createTileBlock(-1, 2),
                factory.createTileBlock(1, 2),
                factory.createTileBlock(0, 3)).forEach(world::spawnEntity);
        return world;
    }

    @Test
    void testIfGoombaDies() {
        final Entity goomba = factory.createGoomba(0, 2);
        final World world = createPrisonAndFallingPlayer(goomba);
        assertTrue(world.getEntities().contains(goomba));
        world.update(DT);
        world.update(DT);
        assertFalse(world.getEntities().contains(goomba));
    }

    @Test
    void testIfKoopaChangesState() {
        final KoopaState koopa = (KoopaState) factory.createKoopa(0, 2);
        final World world = createPrisonAndFallingPlayer(koopa);
        assertTrue(world.getEntities().stream().anyMatch(WalkingKoopa.class::isInstance));
        world.update(DT);
        world.update(DT);
        assertTrue(world.getEntities().stream().anyMatch(TurtleKoopa.class::isInstance));
    }
}
