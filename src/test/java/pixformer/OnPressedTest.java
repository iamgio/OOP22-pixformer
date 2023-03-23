package pixformer;

import org.junit.jupiter.api.Test;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.WorldOptionsFactory;
import pixformer.model.entity.Entity;
import pixformer.model.entity.EntityFactory;
import pixformer.model.entity.EntityFactoryImpl;
import pixformer.model.entity.dynamic.Koopa;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.statics.Block;
import pixformer.view.entity.NullGraphicsComponentFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests to check if the
 * {@link pixformer.model.entity.dynamic.ActionOnPressedCollisionComponent}
 * works.
 */
final class OnPressedTest {

    private static final int SECONDS_TO_MILLIS = 1_000;
    private static final int FPS = 30;
    private static final double DT = (double) SECONDS_TO_MILLIS / FPS * 30;

    private final EntityFactory factory = new EntityFactoryImpl(new NullGraphicsComponentFactory());

    private World createPrisonAndFallingPlayer(final Entity entity) {
        final World world = new WorldImpl(WorldOptionsFactory.testOptions());
        /*
         * p
         * p
         * #g#
         * #
         */
        Set.of(
                entity,
                new Player(0, 0, 1, 2, 0),
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
        assertFalse(world.getEntities().contains(goomba));
    }

    @Test
    void testIfKoopaChangesState() {
        final Koopa koopa = (Koopa) factory.createKoopa(0, 2);
        final World world = createPrisonAndFallingPlayer(koopa);
        assertTrue(koopa.isWalking());
        world.update(DT);
        assertTrue(koopa.isTurtle());
    }
}
