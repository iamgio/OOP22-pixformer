package pixformer.view.entity.player;

import java.util.Optional;

import pixformer.common.Vector2D;
import pixformer.model.entity.powerup.PowerupBehaviour;

/**
 * Represent a semplified model of a Player object.
 * 
 * @param powerup current player powerup.
 * @param velocity current player velocity.
 */
public record PlayerState(Optional<PowerupBehaviour> powerup, Vector2D velocity) {

}
