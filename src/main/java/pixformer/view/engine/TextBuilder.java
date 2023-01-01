package pixformer.view.engine;

/**
 * Builder for text renderers.
 */
public class TextBuilder {

    /**
     * The default font size if not specified.
     */
    public static final double DEFAULT_FONT_SIZE = 16;

    private final String text;
    private Color color;
    private String family;
    private Double size;

    /**
     * Creates a text renderer builder.
     * @param text text to display
     */
    public TextBuilder(String text) {
        this.text = text;
    }

    /**
     * Sets the text color
     * @param color color to set
     * @return this for fluent concatenation
     */
    public TextBuilder withColor(Color color) {
        this.color = color;
        return this;
    }

    /**
     * Sets the font family
     * @param family font family to set
     * @return this for fluent concatenation
     */
    public TextBuilder withFamily(String family) {
        this.family = family;
        return this;
    }

    /**
     * Sets the font size
     * @param size font size to set
     * @return this for fluent concatenation
     */
    public TextBuilder withSize(double size) {
        this.size = size;
        return this;
    }

    /**
     * Builds a text renderer according to the given renderer factory.
     * @param factory renderer factory to create the text
     * @return the suitable text renderer for the given factory
     */
    public PositionableRenderer build(RendererFactory factory) {
        return factory.newText(
                this.text != null ? this.text : "",
                this.color != null ? this.color : Color.BLACK,
                this.family,
                this.size != null ? this.size : DEFAULT_FONT_SIZE
        );
    }
}
