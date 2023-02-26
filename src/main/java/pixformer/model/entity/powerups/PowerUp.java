package pixformer.model.entity.powerups;

import java.util.Optional;

import pixformer.model.entity.dynamics.Player;

public abstract class Powerup {

    protected PowerupBehaviour behaviour;

    public Powerup(PowerupBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    void useAbility(Optional<Player> p) {
        behaviour.ability();
    }
}
