package pixformer.model.entity;

import java.util.function.Function;

import pixformer.model.sound.SoundComponent;

/**
 * A {@link SoundComponent} generator from an {@link Entity} input.
 */
@FunctionalInterface
public interface SoundComponentRetriever extends Function<Entity, SoundComponent> {

}
