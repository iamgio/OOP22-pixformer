package pixformer.view.engine.internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Single-instance utility that handles internationalization of strings via resource bundles.
 */
public final class Lang {

    private static final String BUNDLE_PATH = "lang/lang";
    private static final Lang INSTANCE = new Lang();

    private ResourceBundle bundle;
    private Locale locale;

    /**
     * @return the unique instance of this internationalization helper
     */
    public static Lang getInstance() {
        return INSTANCE;
    }

    /**
     * Initializes an English internationalization.
     */
    private Lang() {
        this.setLocale(Locale.ENGLISH);
        this.update();
    }

    /**
     * @return current locale target
     */
    public Locale getLocale() {
        return this.locale;
    }

    /**
     * Sets a new locale target.
     * @param locale new locale
     */
    public void setLocale(final Locale locale) {
        this.locale = locale;
    }

    /**
     * Updates the resources of the given locale.
     */
    public void update() {
        this.bundle = ResourceBundle.getBundle(BUNDLE_PATH, this.locale);
    }

    /**
     * @param key key from the resource bundle
     * @return value associated to the key, if it exists.
     */
    public String get(final String key) {
        return this.bundle.getString(key);
    }
}
