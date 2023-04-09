package pixformer.view.entity;

import pixformer.model.entity.Entity;
import pixformer.model.sound.SoundComponent;
import pixformer.model.sound.SoundComponentFactory;
import pixformer.view.entity.player.PlayerSoundComponent;
import pixformer.view.entity.powerups.fireball.FireballSoundComponent;

/**
 * Implementation of {@link SoundComponentFactory}.
 */
public class SoundComponentFactoryImpl implements SoundComponentFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public SoundComponent player(final Entity entity) {
        return new PlayerSoundComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SoundComponent fireball(final Entity entity) {
        return new FireballSoundComponent(entity);
    }

}
