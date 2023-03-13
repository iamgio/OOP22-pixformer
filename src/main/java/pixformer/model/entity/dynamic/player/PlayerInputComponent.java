package pixformer.model.entity.dynamic.player;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.input.UserInputComponent;
import pixformer.model.modelinput.CompleteModelInput;

/**
 * Implementation of InputComponent for a Player entity.
 */
public class PlayerInputComponent extends UserInputComponent implements CompleteModelInput {

    private Player player;
    private boolean jumpKey = false;

    /**
     * 
     * @param entity Entity associated with current component
     */
    protected PlayerInputComponent(final Player entity) {
        super(entity);
        player = entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void left() {

        System.out.println("LEFT");

        this.getEntity().setVelocity(this.getEntity().getVelocity().sum(new Vector2D(-PlayerPhysicsComponent.SPEED, 0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void right() {

        System.out.println("RIGHT");

        this.getEntity().setVelocity(this.getEntity().getVelocity().sum(new Vector2D(PlayerPhysicsComponent.SPEED, 0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ability() {

        System.out.println("ABILITY");

        if (player.getPowerup().isPresent()) {
            player.getPowerup().get().getBehaviour().ability();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void jump() {

        System.out.println("JUMP");

        jumpKey = true;

        if (this.player.jump(-PlayerPhysicsComponent.JUMP_FORCE)) {
            this.getEntity().setVelocity(this.getEntity().getVelocity().sum(new Vector2D(0, -PlayerPhysicsComponent.JUMP_FORCE)));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void crouch() {
        System.out.println("CROUCH");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void update(final World world) {
        if (!jumpKey && this.player.isJumping()) {
            this.player.stopJumping();
        }

        jumpKey = false;
    }
}
