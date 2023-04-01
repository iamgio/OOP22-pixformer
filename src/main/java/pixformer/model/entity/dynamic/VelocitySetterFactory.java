package pixformer.model.entity.dynamic;

import pixformer.model.entity.MutableEntity;

/**
 * Factory for velocity setter.
 */
public final class VelocitySetterFactory {

    private VelocitySetterFactory() {

    }

    /**
     * Method to limit the speed of the entity.
     *
     * @param player entity to apply the limit
     * @param speedLimit limit of the speed
     */
    public static void limitSpeed(final MutableEntity entity, final double speedLimit) {
        final double direction = Math.signum(entity.getVelocity().x());
        if (Math.abs(entity.getVelocity().x()) > speedLimit) {
            entity.setVelocity(entity.getVelocity().copyWithX(speedLimit * direction));
        }
    }

    /**
     * Method to limit the vertical speed of the entity.
     *
     * @param player entity to apply the limit
     * @param speedLimit limit of the speed
     */
    public static void limitFallingSpeed(final MutableEntity entity, final double speedLimit) {
        if (entity.getVelocity().y() > speedLimit) {
            entity.setVelocity(entity.getVelocity().copyWithY(speedLimit));
        }
    }
}
