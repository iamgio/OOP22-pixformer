package pixformer.model.entity.dynamic.enemy.ai;

import pixformer.model.entity.MutableEntity;
import pixformer.model.modelinput.HorizontalModelInput;

import java.util.function.BooleanSupplier;

public class MaxedVelocityHorizontalModelInput implements HorizontalModelInput {

    private final Runnable moveRight;
    private final Runnable stop;
    private final Runnable moveLeft;
    private final BooleanSupplier isStill;

    public MaxedVelocityHorizontalModelInput(final MutableEntity entity, final double velocityModule) {
        moveRight = () -> setVelocity(entity, +velocityModule);
        moveLeft = () -> setVelocity(entity, -velocityModule);
        stop = () -> setVelocity(entity, 0);
        isStill = () -> entity.getVelocity().x() == 0;
    }


    @Override
    public void left() {
        moveOrStop(moveLeft);
    }


    @Override
    public void right() {
        moveOrStop(moveRight);
    }
    private static void setVelocity(final MutableEntity entity, final double velocityModule) {
        entity.setVelocity(entity.getVelocity().copyWithX(velocityModule));
    }
    private void moveOrStop(final Runnable move) {
        if (isStill.getAsBoolean()) {
            move.run();
        }
        else {
            stop.run();
        }
    }
}
