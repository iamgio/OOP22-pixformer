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
    private TestEntity c;

    @BeforeEach
    void setup() {
        a = new TestEntity(10);
        b = new TestEntity(11);
        c = new TestEntity(12);
        this.world.spawnEntity(a);
        this.world.spawnEntity(b);
        this.world.spawnEntity(c);
    }

    @Test
    void testScore() {
        world.killEntity(this.a, this.c);
        world.update(1);
        assertEquals(100, world.getScoreManager().getScore(this.c));
        world.killEntity(this.b, this.c);
        world.update(1);
        assertEquals(200, world.getScoreManager().getScore(this.c));
    }
}
