package pixformer.view.entity;

import pixformer.model.entity.Entity;
import pixformer.model.sound.SoundComponent;
import pixformer.model.sound.SoundComponentFactory;
import pixformer.view.engine.GameScene;

/**
 * A sound component factory that does not play any sound.
 */
public final class NullSoundComponentFactory implements SoundComponentFactory {

    /**
     * A shared sound component whose update method does nothing.
     */
    private static final SoundComponent NULL_COMPONENT = new SoundComponent(null) {
        /**
         * {@inheritDoc}
         */
        @Override
        public void update(final GameScene scene) {

        }
    };

    /**
     * {@inheritDoc}
     */
    @Override
    public SoundComponent player(final Entity entity) {
        return NULL_COMPONENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SoundComponent fireball(final Entity entity) {
        return NULL_COMPONENT;
    }

}
