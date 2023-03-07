package pixformer;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.dynamic.Goomba;
import pixformer.model.entity.statics.Block;

public class GoombaAITest {

    private final World world = new WorldImpl();
    private Goomba goomba;

    @BeforeEach
    void setup() {
        goomba = new Goomba(0, 0);
        goomba.setVelocity(new Vector2D(1, 0));
        // world.spawnEntity(new Block(0, 0));
        world.spawnEntity(goomba);
    }

    @Test
    void testClearRoad() {
        world.update(1);
        assertEquals(1, goomba.getX());
        assertEquals(0, goomba.getY());
    }

    @Test
    void testFindObstacle() {
        world.spawnEntity(new Block(1, 0));
        world.update(1);
        assertEquals(1, goomba.getX());
        assertEquals(0, goomba.getY());
        world.update(1);
        assertEquals(0, goomba.getX());
        assertEquals(0, goomba.getY());
    }
}
