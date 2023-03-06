package pixformer;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.collision.EntityCollisionManagerImpl;
import pixformer.model.entity.dynamic.Goomba;
import pixformer.model.entity.statics.Block;

public class GoombaAITest {

    private final World world = new WorldImpl();
    private final Goomba goomba;

    @Before
    void setup() {
        goomba = new Goomba(0, 0);
        // world.spawnEntity(new Block(0, 0));
        world.spawnEntity(goomba);
    }

    @Test
    void testClearRoad() {
        world.update(1);
        assertTrue()
    }
}
