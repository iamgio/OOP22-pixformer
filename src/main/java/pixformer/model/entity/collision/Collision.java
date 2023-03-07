package pixformer.model.entity.collision;

import pixformer.model.entity.Entity;

/**
 * The result of a collision between entities.
 *
 * @param entity the entity the collision has happened with
 * @param side the side the collision happened at
 */
public record Collision(Entity entity, CollisionSide side) {

}
