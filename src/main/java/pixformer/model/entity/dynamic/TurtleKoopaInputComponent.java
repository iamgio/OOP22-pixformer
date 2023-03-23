package pixformer.model.entity.dynamic;

import java.util.function.Consumer;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.dynamic.ai.GoombaAI;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.statics.Block;
import pixformer.model.input.AIInputComponent;
import pixformer.model.input.InputComponent;
import pixformer.model.modelinput.HorizontalModelInput;

/**
 * The InputComponet of the TurtleKoopa. Makes the entity goes like a goomba but
 * it starts moving when colliding with a block o a Player.
 */
public final class TurtleKoopaInputComponent extends AIInputComponent {

    private static final double VELOCITY = 0.012;
    private static final Consumer<HorizontalModelInput> NO_ACTION = (c) -> { };

    private final InputComponent wrappedInputComponent;

    /**
     * @param entity to be controlled.
     */
    public TurtleKoopaInputComponent(final MutableEntity entity) {
        super(entity);
        final MutableEntity proxied = new ProxyMutableEntity(entity);
        wrappedInputComponent = new GoombaAI(getEntity(), proxied::setVelocity, VELOCITY,
                e -> e instanceof Block || e instanceof Player, NO_ACTION);
    }
    @Override
    public void update(final World world) {
        wrappedInputComponent.update(world);
    }

}
