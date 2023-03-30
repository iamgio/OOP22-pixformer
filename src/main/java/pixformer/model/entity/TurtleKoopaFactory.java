package pixformer.model.entity;

/**
 * A factory for creating {@link pixformer.model.entity.dynamic.enemy.koopa.TurtleKoopa}.
 */
public interface TurtleKoopaFactory {

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return a Turtle Koopa entity
     */
    Entity createTurtleKoopa(double x, double y);
}
