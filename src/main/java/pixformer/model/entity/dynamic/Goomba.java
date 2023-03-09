package pixformer.model.entity.dynamic;

/**
 * The enemy gooba.
 */
public class Goomba extends Enemy {

    private final static double WIDTH = 1;
    private final static double HEIGHT = 1;

    public Goomba(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
    }
    
}
