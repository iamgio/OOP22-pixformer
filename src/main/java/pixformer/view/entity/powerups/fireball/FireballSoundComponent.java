package pixformer.view.entity.powerups.fireball;

import pixformer.model.entity.Entity;
import pixformer.model.sound.SoundEvent;
import pixformer.view.entity.CachedSoundComponent;

/**
 * Represent the SoundComponent of a Fireball entity.
 */
public class FireballSoundComponent extends CachedSoundComponent {

    /**
     * @param entity entity linked to this SoundComponent.
     */
    public FireballSoundComponent(final Entity entity) {
        super(entity);
    }

    /**
     * Add to the soundlist the miniJump sound.
     */
    public void fired() {
        this.play(new SoundEvent("sounds/entities/mario/fire/fireball.wav", false));
    }
}
