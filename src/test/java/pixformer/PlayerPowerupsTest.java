package pixformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.WorldOptionsFactory;
import pixformer.model.entity.EntityFactory;
import pixformer.model.entity.EntityFactoryImpl;
import pixformer.model.entity.dynamic.player.PlayerImpl;
import pixformer.model.entity.powerup.powerups.FireFlower;
import pixformer.model.entity.powerup.powerups.Mushroom;
import pixformer.view.entity.NullGraphicsComponentFactory;

/**
 * Test class for player interaction with powerups.
 */
class PlayerPowerupsTest {

    private PlayerImpl player;
    private final World world = new WorldImpl(WorldOptionsFactory.testOptions());
    private final EntityFactory entityFactory = new EntityFactoryImpl(new NullGraphicsComponentFactory(), world);

    /**
     * Reset player status.
     */
    private void playerReset() {
        player = new PlayerImpl(0, 0, 0, entityFactory);
    }

    @Test
    void testSimpleScalarPowerupping() {
        playerReset();
        player.setPowerup(new Mushroom());
        assertEquals(player.getPowerupBehaviour().get().getClass(), Mushroom.class);
        player.setPowerup(new FireFlower());
        assertEquals(player.getPowerupBehaviour().get().getClass(), FireFlower.class);
        player.damaged();
        assertEquals(player.getPowerupBehaviour().get().getClass(), Mushroom.class);
        player.damaged();
        assertEquals(player.getPowerupBehaviour(), Optional.empty());
    }

    @Test
    void testIndirectScalarPowerupping() {
        playerReset();
        player.setPowerup(new FireFlower());
        assertEquals(player.getPowerupBehaviour().get().getClass(), FireFlower.class);
        player.damaged();
        assertEquals(player.getPowerupBehaviour().get().getClass(), Mushroom.class);
        player.damaged();
        assertEquals(player.getPowerupBehaviour(), Optional.empty());
    }
}
