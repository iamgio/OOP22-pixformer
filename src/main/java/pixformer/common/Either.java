package pixformer.common;

import java.util.Optional;

/**
 * Generic Either class.
 * @param <A> first element type
 * @param <B> second element type
 */
public interface Either<A, B> {

    /**
     * @return if is present the first element
     */
    boolean hasFirst();

    /**
     * @return if is present the second element
     */
    boolean hasSecond();

    /**
     * Get the first element.
     * 
     * @return an optional of the first element
     */
    Optional<A> getFirst();

    /**
     * Get the second element.
     * 
     * @return an optional of the second element
     */
    Optional<B> getSecond();

}
