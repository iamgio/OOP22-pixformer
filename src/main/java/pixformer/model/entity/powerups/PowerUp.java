package pixformer.model.entity.powerups;

import java.util.Optional;

import pixformer.model.entity.dynamics.Player;

public interface PowerUp {
    void ability(Optional<Player> p);    
}
