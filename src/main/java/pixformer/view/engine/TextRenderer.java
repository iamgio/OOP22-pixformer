package pixformer.view.engine;

/**
 * The renderer of some text.
 */
public abstract class TextRenderer extends PositionableRenderer {

    private String text;
    private Color color = Color.WHITE;
    private String fontFamily;
    private double fontSize;

    /**
     * Creates a text renderer.
     * @param text text to display
     */
    public TextRenderer(final String text) {
        this.text = text;
    }

    /**
     * @return displayed text
     */
    public String getText() {
        return this.text;
    }

    /**
     * Sets the current text.
     * @param text text to display
     */
    public void setText(final String text) {
        this.text = text;
    }

    /**
     * @return text color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Sets the text color.
     * @param color text color
     */
    public void setColor(final Color color) {
        this.color = color;
    }

    /**
     * @return the font family
     */
    public String getFontFamily() {
        return this.fontFamily;
    }

    /**
     * Sets the font family.
     * @param fontFamily font family
     */
    public void setFontFamily(final String fontFamily) {
        this.fontFamily = fontFamily;
    }

    /**
     * @return the font size
     */
    public double getFontSize() {
        return this.fontSize;
    }

    /**
     * Sets the font size.
     * @param fontSize font size
     */
    public void setFontSize(final double fontSize) {
        this.fontSize = fontSize;
    }
}
