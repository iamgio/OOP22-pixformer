package pixformer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.dynamic.Goomba;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.statics.Block;

/**
 * Tests to check if the
 * {@link pixformer.model.entity.dynamic.DieOnPressedCollisionComponent} works.
 */
public class OnPressedTest {

    private static final int SECONDS_TO_MILLIS = 1_000;
    private static final int FPS = 30;
    private static final double DT = SECONDS_TO_MILLIS / FPS * 30;

    @Test
    void testIfGoombaDies() {
        final World world = new WorldImpl();
        /*
         * p
         * p
         * #g#
         * #
         */
        final Goomba goomba = new Goomba(0, 2);
        Set.of(
                goomba,
                new Player(0, 0, 1, 2, 0),
                new Block(-1, 2),
                new Block(1, 2),
                new Block(0, 3)).forEach(world::spawnEntity);
        world.update(DT);
        assertTrue(!world.getEntities().contains(goomba));
    }
}
