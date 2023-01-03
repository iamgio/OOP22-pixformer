package pixformer.view.engine;

/**
 * A renderer at a specified 2D position.
 */
public abstract class PositionableRenderer implements Renderer {

    private double x;
    private double y;

    /**
     * @return X coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * Sets the X coordinate
     * @param x X coordinate to set
     */
    public void setX(final double x) {
        this.x = x;
    }

    /**
     * @return Y coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * Sets the Y coordinate
     * @param y Y coordinate to set
     */
    public void setY(final double y) {
        this.y = y;
    }

    /**
     * Sets the X and Y coordinates.
     * @param x X coordinate to set
     * @param y Y coordinate to set
     * @return this for fluent concatenation
     */
    public PositionableRenderer at(final double x, final double y) {
        this.x = x;
        this.y = y;
        return this;
    }
}
