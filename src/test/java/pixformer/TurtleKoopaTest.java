package pixformer;

import org.junit.jupiter.api.Test;
import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.WorldOptionsFactory;
import pixformer.model.entity.EntityFactory;
import pixformer.model.entity.EntityFactoryImpl;
import pixformer.model.entity.dynamic.enemy.koopa.TurtleKoopa;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.view.entity.NullGraphicsComponentFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TurtleKoopaTest {

    private static final int FLOOR_HEIGHT = 1;

    private void testTurtleMovesBecauseOfPlayer(final Vector2D playerPos, final double sign) {
        final World world = new WorldImpl(WorldOptionsFactory.testOptions());
        final EntityFactoryImpl factory = new EntityFactoryImpl(new NullGraphicsComponentFactory(), world);
        final TurtleKoopa koopa = (TurtleKoopa) factory.createTurtleKoopa(1, 0);
        for (int i = 0; i < 10; i++) {
            world.spawnEntity(factory.createTileBlock(i, FLOOR_HEIGHT));
        }
        world.spawnEntity(new Player(playerPos.x(), playerPos.y(), 1, 1, 0));
        world.spawnEntity(koopa);
        assertEquals(0, koopa.getVelocity().x());
        world.update(1);
        assertEquals(sign, Math.signum(koopa.getVelocity().x()));
    }

    @Test
    void testTurtleMovesBecauseOfPlayerLeft() {
        testTurtleMovesBecauseOfPlayer(new Vector2D(0, -1), +1);
    }

    @Test
    void testTurtleMovesBecauseOfPlayerRight() {
        testTurtleMovesBecauseOfPlayer(new Vector2D(2, -1), -1);
    }

}
