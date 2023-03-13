package pixformer.model.entity.dynamic;

/**
 * The state of the koopa when it is a turtle.
 */
public class TurtleKoopa extends Enemy implements KoopaState {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    /**
     * Create a new TurtleKoopa
     * 
     * @param x its initial x position
     * @param y its initial y position.
     */
    public TurtleKoopa(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT, 1);
    }

}
