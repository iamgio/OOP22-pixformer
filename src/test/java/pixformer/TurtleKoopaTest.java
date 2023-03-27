package pixformer;

import org.junit.jupiter.api.Test;
import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.WorldOptionsFactory;
import pixformer.model.entity.EntityFactoryImpl;
import pixformer.model.entity.dynamic.enemy.koopa.TurtleKoopa;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.view.entity.NullGraphicsComponentFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TurtleKoopaTest {

    private void testTurtleMovesBecauseOfPlayer(final Vector2D playerPos, final double sign) {
        final World world = new WorldImpl(WorldOptionsFactory.testOptions());
        // final TurtleKoopa koopa = new TurtleKoopa(1, 0, (__, ___) -> { });
        final TurtleKoopa koopa = (TurtleKoopa) new EntityFactoryImpl(new NullGraphicsComponentFactory(), world).createTurtleKoopa(1, 0);
        world.spawnEntity(new Player(playerPos.x(), playerPos.y(), 1, 1, 0));
        world.spawnEntity(koopa);
        assertEquals(koopa.getVelocity().x(), 0);
        world.update(1);
        assertEquals(Math.signum(koopa.getVelocity().x()), sign);
    }

    @Test
    void testTurtleMovesBecauseOfPlayerLeft() {
        testTurtleMovesBecauseOfPlayer(new Vector2D(0, 0), +1);

    }

    @Test
    void testTurtleMovesBecauseOfPlayerRight() {
        testTurtleMovesBecauseOfPlayer(new Vector2D(2, 0), -1);
    }

}
