package pixformer.common;

/**
 * Double 2D Point.
 */
public interface Point2D {

    /**
     * @param x
     * @param y
     * @return a new Point2D whose x component is {@code x} and y component is
     *         {@code y}.
     */
    static Point2D of(final double x, final double y) {
        return new Point2D() {

            @Override
            public double getX() {
                return x;
            }

            @Override
            public double getY() {
                return y;
            }

        };
    }

    /**
     * @return the X component
     */
    double getX();

    /**
     * @return the Y component
     */
    double getY();

}
