package pixformer.common.applier;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Generic applier for a specific consumer.
 */
public interface Applier {

    /**
     * Factory method for the applier.
     * 
     * @param <A>      type of the item
     * @param supplier supplier
     * @param item     item to consume
     * @return a new Applier
     */
    static <A> Applier of(Supplier<Consumer<A>> supplier, A item) {
        return new Applier() {

            @Override
            public void apply() {
                supplier.get().accept(item);
            }
        };
    }

    /**
     * Apply the consumer to the item.
     */
    void apply();

}
