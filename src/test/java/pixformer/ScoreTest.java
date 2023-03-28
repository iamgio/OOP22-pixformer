package pixformer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.WorldOptionsFactory;
import pixformer.model.entity.Entity;
import pixformer.model.entity.dynamic.player.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {

    private final World world = new WorldImpl(WorldOptionsFactory.testOptions());
    private Entity a;
    private Entity b;
    private Entity c;

    @BeforeEach
    void setup() {
        a = new Player(10, 10, 1, 1, 0);
        b = new Player(11, 10, 1, 1, 1);
        c = new Player(12, 10, 1, 1, 2);
        this.world.spawnEntity(a);
        this.world.spawnEntity(b);
        this.world.spawnEntity(c);
    }

    @Test
    void testScore() {
        world.queueEntityKill(this.a, this.c);
        world.update(1);
        assertEquals(100, world.getScoreManager().getScore(this.c).points());
        world.queueEntityKill(this.b, this.c);
        world.update(1);
        assertEquals(200, world.getScoreManager().getScore(this.c).points());
    }
}
