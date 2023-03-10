package pixformer.model.entity.dynamic.player;

import pixformer.model.entity.Entity;
import  pixformer.model.input.InputComponent;
import pixformer.model.input.UserInputComponent;
import pixformer.model.modelinput.CompleteModelInput;

/**
 * Implementation of InputComponent for a Player entity.
 */
public class PlayerInputComponent extends UserInputComponent implements CompleteModelInput {

    /**
     * 
     * @param entity Entity associated with current component
     */
    protected PlayerInputComponent(final Player entity) {
        super(entity);
        //TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void left() {
        this.getEntity().setVelocity(this.getEntity().getVelocity().sum(new Vector2D(-SPEED, 0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void right() {
        this.setVelocity(this.getVelocity().sum(new Vector2D(SPEED, 0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ability() {
        if (this.powerup.isPresent()) {
            this.powerup.get().getBehaviour().ability();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void jump() {
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
        isCrouching = true;
    }

}
