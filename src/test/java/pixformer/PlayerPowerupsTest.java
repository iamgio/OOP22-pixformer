package pixformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import pixformer.model.entity.dynamic.player.PlayerImpl;
import pixformer.model.entity.powerup.powerups.FireFlower;
import pixformer.model.entity.powerup.powerups.Mushroom;

public class PlayerPowerupsTest {
    
    PlayerImpl player;

    public PlayerPowerupsTest() {
    }

    private void playerReset() {
        player = new PlayerImpl(0,0);
    }

    @Test
    void testSimpleScalarPowerupping() {
        playerReset();
        player.setPowerup(new Mushroom());
        assertEquals(player.getPowerupBehaviour().get().getClass(), new Mushroom().getClass());
        player.setPowerup(new FireFlower());
        assertEquals(player.getPowerupBehaviour().get().getClass(), new FireFlower().getClass());
        player.damaged();
        assertEquals(player.getPowerupBehaviour().get().getClass(), new Mushroom().getClass());
        player.damaged();
        assertEquals(player.getPowerupBehaviour(), Optional.empty());
    }

    @Test
    void testIndirectScalarPowerupping() {
        playerReset();
        player.setPowerup(new FireFlower());
        assertEquals(player.getPowerupBehaviour().get().getClass(), new FireFlower().getClass());
        player.damaged();
        assertEquals(player.getPowerupBehaviour().get().getClass(), new Mushroom().getClass());
        player.damaged();
        assertEquals(player.getPowerupBehaviour(), Optional.empty());
    }
}
