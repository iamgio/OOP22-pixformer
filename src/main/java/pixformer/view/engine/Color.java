package pixformer.view.engine;

/**
 * An immutable RGBA color.
 */
public final class Color {

    /**
     * The maximum value of an RGBA component.
     */
    private static final double COMPONENT_UPPER_BOUND = 1.0;

    /**
     * The maximum value of an RGBA component of an AWT {@link java.awt.Color}.
     */
    private static final int AWT_COMPONENT_UPPER_BOUND = 255;

    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color WHITE = new Color(COMPONENT_UPPER_BOUND, COMPONENT_UPPER_BOUND, COMPONENT_UPPER_BOUND);

    private final double red;
    private final double green;
    private final double blue;
    private final double alpha;

    /**
     * Creates a new RGBA color.
     * @param red red component in range 0-1
     * @param green green component in range 0-1
     * @param blue blue component in range 0-1
     * @param alpha alpha component in range 0-1
     */
    public Color(final double red, final double green, final double blue, final double alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    /**
     * Creates a new RGB color.
     * @param red red component in range 0-1
     * @param green green component in range 0-1
     * @param blue blue component in range 0-1
     */
    public Color(final double red, final double green, final double blue) {
        this(red, green, blue, COMPONENT_UPPER_BOUND);
    }

    /**
     * @return the red component in range 0-1
     */
    public double getRed() {
        return this.red;
    }

    /**
     * @return the green component in range 0-1
     */
    public double getGreen() {
        return this.green;
    }

    /**
     * @return the blue component in range 0-1
     */
    public double getBlue() {
        return this.blue;
    }

    /**
     * @return the alpha component in range 0-1
     */
    public double getAlpha() {
        return this.alpha;
    }

    /**
     * @return this color to a JavaFX {@link javafx.scene.paint.Color}
     */
    public javafx.scene.paint.Color toJFX() {
        return new javafx.scene.paint.Color(this.red, this.green, this.blue, this.alpha);
    }

    /**
     * @return this color to an AWT {@link java.awt.Color}
     */
    public java.awt.Color toAWT() {
        return new java.awt.Color(
                (int) (this.red * AWT_COMPONENT_UPPER_BOUND),
                (int) (this.green * AWT_COMPONENT_UPPER_BOUND),
                (int) (this.blue * AWT_COMPONENT_UPPER_BOUND),
                (int) (this.alpha * AWT_COMPONENT_UPPER_BOUND)
        );
    }

    /**
     * @param color JavaFX {@link javafx.scene.paint.Color} to convert
     * @return the JavaFX color converted to a generic color
     */
    public static Color fromJFX(final javafx.scene.paint.Color color) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getOpacity());
    }

    /**
     * @param color AWT {@link java.awt.Color} to convert
     * @return the AWT color converted to a generic color
     */
    public static Color fromAWT(final java.awt.Color color) {
        return new Color(
                (double) color.getRed() / AWT_COMPONENT_UPPER_BOUND,
                (double) color.getGreen() / AWT_COMPONENT_UPPER_BOUND,
                (double) color.getBlue() / AWT_COMPONENT_UPPER_BOUND,
                (double) color.getAlpha() / AWT_COMPONENT_UPPER_BOUND
        );
    }
}
