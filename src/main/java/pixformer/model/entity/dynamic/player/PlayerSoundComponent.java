package pixformer.model.entity.dynamic.player;

import pixformer.model.entity.Entity;
import pixformer.model.sound.SoundComponent;
import pixformer.model.sound.SoundEvent;

/**
 * Represent the SoundComponent of a Player entity.
 */
public class PlayerSoundComponent extends SoundComponent {

    /**
     * @param entity entity linked to this SoundComponent.
     */
    protected PlayerSoundComponent(final Entity entity) {
        super(entity);
    }

    /**
     * Add to the soundlist the miniJump sound.
     */
    public void miniJumpSound() {
        this.addSound(new SoundEvent("sounds/entities/mario/common/jump_mini.wav", false));
    }

    /**
     * Add to the soundlist the bigJump sound.
     */
    public void bigJumpSound() {
        this.addSound(new SoundEvent("sounds/entities/mario/common/jump_big.wav", false));
    }

    /**
     * Add to the soundlist the get-powerup sound.
     */
    public void upgrade() {
        this.addSound(new SoundEvent("sounds/entities/mario/common/get_powerup.wav", false));
    }

    /**
     * Add to the soundlist the dying sound.
     */
    public void marioDies() {
        this.addSound(new SoundEvent("sounds/entities/mario/common/mario_dies.wav", false));
    }
}
