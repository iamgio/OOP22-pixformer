package pixformer.view.entity.player;

import java.util.Optional;

import pixformer.common.Vector2D;
import pixformer.model.entity.powerup.PowerUp;

public record PlayerState(Optional<PowerUp> powerup, Vector2D velocity) {
    
}
