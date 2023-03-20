package pixformer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.Entity;
import pixformer.model.entity.dynamic.Goomba;
import pixformer.model.entity.dynamic.Koopa;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.statics.Block;

/**
 * Tests to check if the
 * {@link pixformer.model.entity.dynamic.ActionOnPressedCollisionComponent}
 * works.
 */
public class OnPressedTest {

    private static final int SECONDS_TO_MILLIS = 1_000;
    private static final int FPS = 30;
    private static final double DT = SECONDS_TO_MILLIS / FPS * 30;

    private World createPrisonAndFallingPlayer(final Entity entity) {
        final World world = new WorldImpl();
        /*
         * p
         * p
         * #g#
         * #
         */
        Set.of(
                entity,
                new Player(0, 0, 1, 2, 0),
                new Block(-1, 2),
                new Block(1, 2),
                new Block(0, 3)).forEach(world::spawnEntity);
        return world;
    }

    @Test
    void testIfGoombaDies() {
        final Goomba goomba = new Goomba(0, 2);
        final World world = createPrisonAndFallingPlayer(goomba);
        assertTrue(world.getEntities().contains(goomba));
        world.update(DT);
        assertTrue(!world.getEntities().contains(goomba));
    }

    @Test
    void testIfKoopaChangesState() {
        final Koopa koopa = new Koopa(0, 2);
        final World world = createPrisonAndFallingPlayer(koopa);
        assertTrue(koopa.isWalking());
        world.update(DT);
        assertTrue(koopa.isTurtle());
    }
}
