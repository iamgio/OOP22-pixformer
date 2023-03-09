package pixformer.model.entity.dynamic;

public class TurtleKoopa extends Enemy implements Koopa {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    public TurtleKoopa(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
    }
    
}
