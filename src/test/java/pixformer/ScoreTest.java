package pixformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.TestEntity;

public class ScoreTest {

    private final World world = new WorldImpl();
    private TestEntity a;
    private TestEntity b;

    @BeforeEach
    void setup() {
        a = new TestEntity(10);
        b = new TestEntity(11);
        this.world.spawnEntity(a);
        this.world.spawnEntity(b);
    }

    @Test
    void testScore() {
        world.killEntity(this.a);
        world.update(1);
        assertEquals(100, world.getScoreManager().getScore());
        world.killEntity(this.b);
        world.update(1);
        assertEquals(200, world.getScoreManager().getScore());
    }
}
