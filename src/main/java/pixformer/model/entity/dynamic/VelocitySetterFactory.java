package pixformer.model.entity.dynamic;

import pixformer.model.entity.MutableEntity;

public final class VelocitySetterFactory {

    public static void limitSpeed(final MutableEntity player, final double speedLimit) {
        final double direction = Math.signum(player.getVelocity().x());
        if (Math.abs(player.getVelocity().x()) > speedLimit) {
            player.setVelocity(player.getVelocity().copyWithX(speedLimit * direction));
        }
    }
}
