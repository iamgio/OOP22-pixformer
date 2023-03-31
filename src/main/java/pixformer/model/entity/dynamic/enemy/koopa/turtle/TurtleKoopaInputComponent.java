package pixformer.model.entity.dynamic.enemy.koopa.turtle;

import pixformer.model.World;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.dynamic.OnlyXVelocitySetter;
import pixformer.model.entity.dynamic.enemy.ai.GoombaAI;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.statics.Block;
import pixformer.model.input.AIInputComponent;
import pixformer.model.input.InputComponent;
import pixformer.model.modelinput.HorizontalModelInput;

import java.util.function.Consumer;

/**
 * The InputComponet of the TurtleKoopa. Makes the entity goes like a goomba but
 * it starts moving when colliding with a block o a Player.
 */
public final class TurtleKoopaInputComponent extends AIInputComponent {

    private static final double VELOCITY = 0.012;
    private static final Consumer<HorizontalModelInput> NO_ACTION = (c) -> { };

    private final InputComponent wrappedInputComponent;
    private final InputComponent moveWhenPressed;

    /**
     * @param entity to be controlled.
     */
    public TurtleKoopaInputComponent(final MutableEntity entity) {
        super(entity);
        wrappedInputComponent = new GoombaAI(getEntity(), new OnlyXVelocitySetter(entity), VELOCITY,
                e -> e instanceof Block || (e instanceof Player && entity.getVelocity().x() == 0), NO_ACTION);
        moveWhenPressed = new MoveWhenPressedInputComponent(entity, VELOCITY);
    }
    @Override
    public void update(final World world) {
        wrappedInputComponent.update(world);
        moveWhenPressed.update(world);
    }

}
