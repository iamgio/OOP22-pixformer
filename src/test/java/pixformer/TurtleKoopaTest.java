package pixformer;

import org.junit.jupiter.api.Test;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.WorldOptionsFactory;
import pixformer.model.entity.dynamic.TurtleKoopa;
import pixformer.model.entity.dynamic.player.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TurtleKoopaTest {

    @Test
    void testTurtleMovesBecauseOfPlayerLeft() {
        final World world = new WorldImpl(WorldOptionsFactory.testOptions());
        final TurtleKoopa koopa = new TurtleKoopa(1, 0, (__) -> { });
        world.spawnEntity(new Player(0, 0, 1, 1, 0));
        world.spawnEntity(koopa);
        assertEquals(koopa.getVelocity().x(), 0);
        world.update(1);
        assertTrue(koopa.getVelocity().x() > 0);
    }

    @Test
    void testTurtleMovesBecauseOfPlayerRight() {
        final World world = new WorldImpl(WorldOptionsFactory.testOptions());
        final TurtleKoopa koopa = new TurtleKoopa(1, 0, (__) -> { });
        world.spawnEntity(new Player(2, 0, 1, 1, 0));
        world.spawnEntity(koopa);
        assertEquals(koopa.getVelocity().x(), 0);
        world.update(1);
        assertTrue(koopa.getVelocity().x() < 0);
    }

}
