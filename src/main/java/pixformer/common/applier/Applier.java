package pixformer.common.applier;

import java.util.function.Consumer;

/**
 * Generic applier for a specific consumer.
 */
public interface Applier {

    /**
     * Factory method for the applier.
     * 
     * @param <A>      type of the item
     * @param consumer consumer
     * @param item     item to consume
     * @return a new Applier
     */
    static <A> Applier of(Consumer<A> consumer, A item) {
        return new Applier() {

            @Override
            public void apply() {
                consumer.accept(item);
            }
        };
    }

    /**
     * Apply the consumer to the item
     */
    void apply();

}
