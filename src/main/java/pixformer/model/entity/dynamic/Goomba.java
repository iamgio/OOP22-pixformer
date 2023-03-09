package pixformer.model.entity.dynamic;

/**
 * The enemy gooba.
 */
public class Goomba extends Enemy {

    private static final double INITIAL_VELOCITY = 0.002; // calcoli fatti a mano
    private final static double WIDTH = 1;
    private final static double HEIGHT = 1;

    public Goomba(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT, INITIAL_VELOCITY);
    }
    
}
