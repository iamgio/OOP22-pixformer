package pixformer.view.entity.player;

import pixformer.model.entity.Entity;
import pixformer.model.sound.SoundEvent;
import pixformer.view.entity.CachedSoundComponent;

/**
 * Represent the SoundComponent of a Player entity.
 */
public class PlayerSoundComponent extends CachedSoundComponent {

    /**
     * @param entity entity linked to this SoundComponent.
     */
    public PlayerSoundComponent(final Entity entity) {
        super(entity);
    }

    /**
     * Add to the soundlist the miniJump sound.
     */
    public void miniJumpSound() {
        this.play(new SoundEvent("sounds/entities/mario/common/jump_mini.wav", false));
    }

    /**
     * Add to the soundlist the bigJump sound.
     */
    public void bigJumpSound() {
        this.play(new SoundEvent("sounds/entities/mario/common/jump_super.wav", false));
    }

    /**
     * Add to the soundlist the get-powerup sound.
     */
    public void upgrade() {
        this.play(new SoundEvent("sounds/entities/mario/common/get_powerup.wav", false));
    }

    /**
     * Add to the soundlist the dying sound.
     */
    public void marioDies() {
        this.play(new SoundEvent("sounds/entities/mario/common/mario_dies.wav", false));
    }
}
