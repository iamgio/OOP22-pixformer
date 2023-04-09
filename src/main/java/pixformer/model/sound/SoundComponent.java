package pixformer.model.sound;

import pixformer.model.entity.Entity;
import pixformer.model.entity.components.Component;
import pixformer.view.engine.GameScene;

/**
 * Represents the component that manages the sound of entities.
 */
public abstract class SoundComponent extends Component<Entity> {

    /**
     * @param entity linked to the Soundcomponent.
     */
    protected SoundComponent(final Entity entity) {
        super(entity);
    }


    /**
     * Updates the game scene with the new sounds to play.
     * 
     * @param scene game scene to play on
     */
    public abstract void update(GameScene scene);
}
