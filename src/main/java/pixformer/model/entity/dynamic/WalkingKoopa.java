package pixformer.model.entity.dynamic;

/**
 * The state of the koopa which walks normally and behaves like a goomba.
 */
public class WalkingKoopa extends Enemy implements Koopa {

    private static final double INITIAL_VELOCITY = 0.002; // calcoli fatti a mano
    private static double WIDTH = 1;
    private static double HEIGHT = 2;
    
    /**
     * Construct a WalkingKoopa.
     * @param x its initial x position
     * @param y its initial x position.
     */
    public WalkingKoopa(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT, INITIAL_VELOCITY);
    }
}
