package pixformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.dynamic.Goomba;

public class GravityTest {

    private final World world = new WorldImpl();
    private Goomba goomba;

    @BeforeEach
    void setup() {
        goomba = new Goomba(0, 0);
        goomba.setVelocity(new Vector2D(0, 0));
        world.spawnEntity(goomba);
    }

    @Test
    void testDrop() {
        world.update(1);
        assertEquals(0, goomba.getX());
        assertEquals(1, goomba.getY());
        world.update(1);
        assertEquals(0, goomba.getX());
        assertEquals(2, goomba.getY());
    }

}
