package pixformer.model.entity.powerup.other.fireball;

import pixformer.model.entity.Entity;
import pixformer.model.sound.SoundComponent;
import pixformer.model.sound.SoundEvent;

/**
 * Represent the SoundComponent of a Fireball entity.
 */
public class FireballSoundComponent extends SoundComponent {

    /**
     * @param entity entity linked to this SoundComponent.
     */
    protected FireballSoundComponent(final Entity entity) {
        super(entity);
    }

    /**
     * Add to the soundlist the miniJump sound.
     */
    public void fired() {
        this.addSound(new SoundEvent("sounds/entities/mario/fire/fireball.wav", false));
    }
}
