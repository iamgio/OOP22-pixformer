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
    public static void limitSpeed(final MutableEntity player, final double speedLimit) {
        final double direction = Math.signum(player.getVelocity().x());
        if (Math.abs(player.getVelocity().x()) > speedLimit) {
            player.setVelocity(player.getVelocity().copyWithX(speedLimit * direction));
        }
    }
}
