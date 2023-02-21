package pixformer.model.input;

import pixformer.model.entity.Entity;

/**
 * A user-controlled input component.
 */
public class UserInputComponent extends InputComponent {

    /**
     * Instantiates a user-controlled input component.
     * @param entity target entity
     */
    public UserInputComponent(final Entity entity) {
        super(entity);
        // TODO add hooks: player.addOnX(() -> ...)
        // e.g.: player.addOnJump(entity::jump)
    }

    @Override
    public void update(final double dt) {
        // Empty
    }
}
