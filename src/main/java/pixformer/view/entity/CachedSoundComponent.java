package pixformer.view.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.OverridingMethodsMustInvokeSuper;

import pixformer.model.entity.Entity;
import pixformer.model.sound.SoundComponent;
import pixformer.model.sound.SoundEvent;
import pixformer.view.engine.GameScene;

/**
 * Represents the component that manages the sound of entities.
 */
public abstract class CachedSoundComponent extends SoundComponent {
    private final List<SoundEvent> soundList = new ArrayList<>();

    /**
     * @param entity linked to the Soundcomponent.
     */
    protected CachedSoundComponent(final Entity entity) {
        super(entity);
    }

    /**
     * Add a sound to the sound list.
     * @param newSound new entity sound.
     */
    protected void play(final SoundEvent newSound) {
        soundList.add(newSound);
    }

    /**
     * Updates the game scene with the new sounds to play.
     * 
     * @param scene game scene to play on
     */
    @Override
    @OverridingMethodsMustInvokeSuper
    public void update(final GameScene scene) {
        scene.playSounds(soundList);
        soundList.clear();
    }
}
