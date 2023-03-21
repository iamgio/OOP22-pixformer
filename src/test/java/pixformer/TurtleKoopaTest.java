package pixformer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.dynamic.TurtleKoopa;
import pixformer.model.entity.dynamic.player.Player;

class TurtleKoopaTest {
    
    @Test
    void testTurtleMovesBecauseOfPlayer() {
        final World world = new WorldImpl();
        final TurtleKoopa koopa = new TurtleKoopa(1, 0);
        world.spawnEntity(new Player(0, 0, 1, 1, 0));
        world.spawnEntity(koopa);
        assertTrue(koopa.getVelocity().x() == 0);
        world.update(1);
        assertTrue(koopa.getVelocity().x() > 0);
    }

}
