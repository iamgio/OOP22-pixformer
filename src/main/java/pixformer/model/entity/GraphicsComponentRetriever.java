package pixformer.model.entity;

import java.util.function.Function;

/**
 * A {@link GraphicsComponent} generator from an {@link Entity} input.
 */
@FunctionalInterface
public interface GraphicsComponentRetriever extends Function<Entity, GraphicsComponent> {

}
