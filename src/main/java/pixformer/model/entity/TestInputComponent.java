package pixformer.model.entity;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.input.UserInputComponent;
import pixformer.model.modelinput.CompleteModelInput;

/**
 * Input component for the test entity.
 *
 * @deprecated test
 */
@Deprecated
public class TestInputComponent extends UserInputComponent implements CompleteModelInput {

    private double jumpForce;

    public TestInputComponent(AbstractEntity testEntity) {
        super(testEntity);
        this.resetJump();
        // Si potrebbe non tenere il campo con l'entità specifica,
        // ed usare super.getEntity() appena Entity esporrà setX
    }

    @Override
    public void jump() {
        if (super.getEntity().getVelocity().y() <= 0) {
            super.getEntity().setVelocity(new Vector2D(0, jumpForce += 0.0005));
        }
    }

    @Override
    public void left() {

    }

    @Override
    public void right() {

    }

    @Override
    public void crouch() {

    }

    @Override
    public void ability() {

    }

    private void resetJump() {
        this.jumpForce = -0.02;
    }

    @Override
    public void update(final World world) {
        if (getEntity().isOnGround()) {
            this.resetJump();
        }
    }
}
