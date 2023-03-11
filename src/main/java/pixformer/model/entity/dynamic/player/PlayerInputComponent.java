package pixformer.model.entity.dynamic.player;

import pixformer.common.Vector2D;
import pixformer.model.entity.Entity;
import  pixformer.model.input.InputComponent;
import pixformer.model.input.UserInputComponent;
import pixformer.model.modelinput.CompleteModelInput;

/**
 * Implementation of InputComponent for a Player entity.
 */
public class PlayerInputComponent extends UserInputComponent implements CompleteModelInput {

    private Player player;

    /**
     * 
     * @param entity Entity associated with current component
     */
    protected PlayerInputComponent(final Player entity) {
        super(entity);
        player = entity;
        //TODO Auto-generated constructor stub
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

        if ( this.player.isOnGround()) {
            this.getEntity().setVelocity(this.getEntity().getVelocity().sum(new Vector2D(0, -PlayerPhysicsComponent.JUMP_FORCE)));
        }

        /*
        boolean isGrounded;

        if ( isGrounded ) {
            this.isJumping = true;
        }

        // Manage jumping
        if (this.isGrounded) {
            // Reset jumpTimeCounter
            this.jumpTimeCounter = MAX_JUMP_DURATION;
        } else {
            this.jumpTimeCounter -= dt;
        }

        if (!this.jumpingKey) {
            this.jumpTimeCounter = 0;
        }
        if (this.jumpTimeCounter <= 0) {
            this.isJumping = false;
        }

        // Player is jumping (moving up)
        if (this.isJumping) {
            //updatePos(new Vector2D(0, JUMP_FORCE), dt);
        }

        // Player is falling down
        if (!this.isGrounded && !this.isJumping) {
            //updatePos(new Vector2D(0, -GRAVITY), dt);
        }*/
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void crouch() {        

        System.out.println("CROUCH");
    }

}
