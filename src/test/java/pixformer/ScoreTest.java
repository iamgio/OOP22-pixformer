package pixformer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.WorldOptionsFactory;
import pixformer.model.entity.TestEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {

    private final World world = new WorldImpl(WorldOptionsFactory.testOptions());
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
        world.queueEntityKill(this.a, this.c);
        world.update(1);
        assertEquals(100, world.getScoreManager().getScore(this.c));
        world.queueEntityKill(this.b, this.c);
        world.update(1);
        assertEquals(200, world.getScoreManager().getScore(this.c));
    }
}
