package pixformer.view.engine.internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Single-instance utility that handles internationalization of strings via resource bundles.
 */
public final class Lang {

    private static final String BUNDLE_PATH = "lang/lang";
    private static final Lang INSTANCE = new Lang();

    private final Locale locale;
    private ResourceBundle bundle;

    /**
     * @return the unique instance of this internationalization helper
     */
    public static Lang getInstance() {
        return INSTANCE;
    }

    /**
     * Initializes a custom internationalization.
     * @param locale target locale
     */
    private Lang(final Locale locale) {
        this.locale = locale;
        this.update();
    }

    /**
     * Initializes an English internationalization.
     */
    private Lang() {
        this(Locale.ENGLISH);
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
