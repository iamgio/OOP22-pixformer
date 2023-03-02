package pixformer.common;

import java.util.Optional;

/**
 * {@inheritDoc}.
 */
public class EitherImpl<A, B> implements Either <A, B>{
    private final Optional<A> first;
    private final Optional<B> second;

    /**
     * Create an EitherImpl containing only the first element
     * @param first element of the Either
     * @return a new EitherImpl
     * @param <A> type of the first element
     * @param <B> type of the second element
     */
    static <A, B> EitherImpl<A, B> createFirst(final Optional<A> first) {
        return new EitherImpl<>(first, null);
    }

    /**
     * Create an EitherImpl containing only the second element
     * @param second element of the Either
     * @return a new EitherImpl
     * @param <A> type of the first element
     * @param <B> type of the second element
     */
    static <A, B> EitherImpl<A, B> createSecond(final Optional<B> second) {
        return new EitherImpl<>(null, second);
    }

    private EitherImpl(final Optional<A> first, final Optional<B> second) {
        this.first = first;
        this.second = second;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean hasFirst() {
        return first.isPresent();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean hasSecond() {
        return second.isPresent();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Optional<A> getFirst() {
        return first;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Optional<B> getSecond() {
        return second;
    }

}
