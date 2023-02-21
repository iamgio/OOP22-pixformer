package pixformer.model.entity.dynamics;

import pixformer.common.Updatable;
import pixformer.common.Vector2D;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.modelinput.CompleteModelInput;

/**
 * The class manages the character used by the player.
 */
public class Player implements DrawableEntity, Updatable, CompleteModelInput {
    static final double GRAVITY = 1.0;
    static final double SPEED = 1.0;


    //Current Player position
    private Vector2D position;


    //State variables to check if player is jumping or crouching
    private boolean isCrouching;
    private boolean isJumping;


    //State variable to check if player is touching ground
    private boolean isGrounded = true;


    //Max duration of a jump
    static final double MAXJUMPDURATION = 5.0;
    static final double JUMPFORCE = 1.0;


    //Current jump state
    private double jumpTimeCounter = MAXJUMPDURATION;


    // Variables to manage player input


    //True if in the last timeslot has been pressed a movement key
    private boolean leftKey;
    private boolean rightKey;

    //True if in the last timeslot has been pressed the ability key (to activate player ability, if possible)
    /*private boolean abilityKey;*/
    //True if in the last timeslot has been pressed the jump key (to continue the jump of fall down)
    private boolean jumpingKey;


    /**
     * @param position Initial player position
     */
    public Player(final Vector2D position) {
        this.position = position;
        //this.isGrounded = groundHitbox(); <-- Dovrebbe essere così
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getX() {
        return position.x();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getY() {
        return position.y();
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
    public GraphicsComponent getGraphicsComponent() {
        // TODO Auto-generated method stub
        return null;
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


        this.position = this.position.sum(new Vector2D(SPEED * dt * movement, 0));


        //Manage jumping
        if (this.isGrounded) {
            //Reset jumpTimeCounter
            this.jumpTimeCounter = MAXJUMPDURATION;
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
            this.position.sum(new Vector2D(0, JUMPFORCE * dt));
        }


        //Player is falling down
        if (!this.isGrounded && !this.isJumping) {
            this.position.sum(new Vector2D(0, -GRAVITY * dt));
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
}
