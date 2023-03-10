package pixformer.model.entity.dynamic;

/**
 * The enemy gooba.
 */
public class Goomba extends Enemy {

    private static final double INITIAL_VELOCITY = 0.002; // calcoli fatti a mano
    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    /**
     * Create a new Goomba.
     * 
     * @param x its initial x coordinate position.
     * @param y its initial y coordinate position.
     */
    public Goomba(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT, INITIAL_VELOCITY);
    }

}
