package pixformer.model.entity;

import pixformer.model.sound.SoundComponent;

/**
 * In-Game entity that can play sounds with it's SoundComponent.
 */
public interface SoundableEntity extends Entity {

    /**
     * @return the entity's soundComponent
     */
    SoundComponent getSoundComponent();

}
