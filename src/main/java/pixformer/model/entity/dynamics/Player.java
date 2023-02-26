package pixformer.model.entity.dynamics;

import java.util.Optional;

import pixformer.common.Updatable;
import pixformer.common.Vector2D;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.modelinput.CompleteModelInput;
import pixformer.model.entity.powerups.Powerup;

/**
 * The class manages the character used by the player.
 */
public class Player extends AbstractEntity implements Updatable, CompleteModelInput, DrawableEntity, DefaultRectangleBoundingBoxEntity
{
    static final double GRAVITY = 1.0;
    static final double SPEED = 1.0;

    //State variables to check if player is jumping or crouching
    private boolean isCrouching;
    private boolean isJumping;


    //State variable to check if player is touching ground
    private boolean isGrounded = true;


    //Max duration of a jump
    static final double MAX_JUMP_DURATION = 5.0;
    static final double JUMP_FORCE = 1.0;

    //Current jump state
    private double jumpTimeCounter = MAX_JUMP_DURATION;

    // Variables to manage player input, True if in the last timeslot has been pressed a movement key, False otherwise
    private boolean leftKey;
    private boolean rightKey;
    /*private boolean abilityKey;*/
    private boolean jumpingKey;

    //Current powerup
    Optional<Powerup> powerup;

    /**
     * @param position Initial player position
     */
    public Player(final double x, final double y, final double width, final double height) {
        super(x, y, width, height);
        //this.isGrounded = groundHitbox(); <-- Dovrebbe essere così
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void left() {
        this.leftKey = true;
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void right() {
        this.rightKey = true;
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void ability() {
        /*this.abilityKey = true;*/
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void jump() {
        this.jumpingKey = true;

        if (this.isGrounded) {
            this.isJumping = true;
        }
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void crouch() {
        isCrouching = true;
    }

    /*@Override
    public Vector2D getPosition() {
        return this.position;
    }*/

    /**
     * @return True if is crouching.
     */
    public boolean isCrouching() {
        return isCrouching;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getWidth() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getHeight() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        //Manage movement
        int movement = 0;


        if (this.leftKey) {
            movement--;
        }


        if (this.rightKey) {
            movement++;
        }

        updatePos(new Vector2D(SPEED * movement, 0), dt);

        //Manage jumping
        if (this.isGrounded) {
            //Reset jumpTimeCounter
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

        //Player is jumping (moving up)
        if (this.isJumping) {
            updatePos(new Vector2D(0, JUMP_FORCE), dt);
        }

        //Player is falling down
        if (!this.isGrounded && !this.isJumping) {
            updatePos(new Vector2D(0, -GRAVITY), dt);
        }

        //Manage abilities
        /*
        if (this.abilityKey) {
            //NEED TO IMPLEMENT UPGRADES
        }
        */

        /*
            Manage collisions     !!!
        */
        //If grounded
        this.isGrounded = true;
        //else
        this.isGrounded = false;

        //reset keys variables
        this.leftKey = false;
        this.rightKey = false;
        this.jumpingKey = false;
        /*this.abilityKey = false;*/
    }

    @Override
    public GraphicsComponent getGraphicsComponent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGraphicsComponent'");
    }
}
