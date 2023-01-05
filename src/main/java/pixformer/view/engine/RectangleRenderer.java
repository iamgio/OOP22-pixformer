package pixformer.view.engine;

/**
 * The renderer of a solid rectangle.
 */
public abstract class RectangleRenderer extends PositionableRenderer {

    private double width;
    private double height;
    private Color color = Color.BLACK;

    /**
     * Creates a rectangle renderer
     * @param width rectangle width
     * @param height rectangle height
     */
    public RectangleRenderer(final double width, final double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * @return rectangle width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width.
     * @param width rectangle width
     */
    public void setWidth(final double width) {
        this.width = width;
    }

    /**
     * @return rectangle height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Sets the height
     * @param height rectangle height
     */
    public void setHeight(final double height) {
        this.height = height;
    }

    /**
     * @return fill color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Sets the fill color
     * @param color fill color
     */
    public void setColor(final Color color) {
        this.color = color;
    }
}
