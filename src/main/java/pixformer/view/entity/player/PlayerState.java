package pixformer.view.entity.player;

import java.util.Optional;

import pixformer.common.Vector2D;
import pixformer.model.entity.powerup.PowerupBehaviour;

public record PlayerState(Optional<PowerupBehaviour> powerup, Vector2D velocity) {
    
}
