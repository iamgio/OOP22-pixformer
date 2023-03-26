package pixformer.view.entity.player;

import java.util.List;
import java.util.Optional;

import pixformer.common.Vector2D;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.dynamic.player.PlayerInputComponent;
import pixformer.model.entity.powerup.PowerupBehaviour;
import pixformer.model.entity.powerup.powerups.FireFlower;
import pixformer.model.entity.powerup.powerups.Mushroom;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.CachedAnimatedGraphicsComponent;

/**
 * Implementation of GraphicComponent for a Player entity.
 */
public class PlayerGraphicsComponent extends CachedAnimatedGraphicsComponent {
    private static final long SWITCH_TIME = 200;
    private static final double IDLE_VELOCITY = 0.000_000_1;

    private final Player player;
    private PlayerState previousState;
    private List<Renderer> renderers;

    /**
     * 
     * @param player Player entity who will be displayed.
     */
    public PlayerGraphicsComponent(final Player player) {
        super(player, SWITCH_TIME);
        this.player = player;
        this.previousState = new PlayerState(player.getPowerupBehaviour(), player.getVelocity());
    }

    /**
     * {@inheritDoc}
     * @implNote it saves the new renderers on cache at initialization
     */
    @Override
    protected List<Renderer> getRenderers(final RendererFactory factory) {
        PlayerState newState = getNewPlayerState(player);

        if (!previousState.equals(newState) || renderers == null) {
            renderers = createRenderers(factory);
        }

        previousState = newState;
        return renderers;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<Renderer> createRenderers(final RendererFactory factory) {
        PlayerSpriteFactory spriteFactory = new PlayerSpriteFactory();
        PlayerAnimation animation = spriteFactory.getPlayerAnimation();

        Optional<PowerupBehaviour> currentPowerup = player.getPowerup().getBehaviour();
        if (currentPowerup.isEmpty()) {
            animation = spriteFactory.getPlayerAnimation();
        } else if (currentPowerup.get() instanceof Mushroom) {
            animation = spriteFactory.getMushroomPlayerAnimation();
        } else if (currentPowerup.get() instanceof FireFlower) {
            animation = spriteFactory.getFireFlowerPlayerAnimation();
        }

        if (player.getVelocity().y() != 0) {
            return animation.getJumpRenderer(factory, player);
        }

        if (Math.abs(player.getVelocity().x()) > PlayerInputComponent.BASE_SPEED_LIMIT) {
            return animation.getRunRenderer(factory, player);
        }

        if (Math.abs(player.getVelocity().x()) > IDLE_VELOCITY) {
            return animation.getWalkRenderer(factory, player);
        }

        return animation.getIdleRenderer(factory, player);
    }

    private PlayerState getNewPlayerState(final Player player) {
        double fixedX = 0;
        double fixedY = 0;

        if (Math.abs(player.getVelocity().x()) > PlayerInputComponent.BASE_SPEED_LIMIT) {
            fixedX = 2;
        } else if (Math.abs(player.getVelocity().x()) > IDLE_VELOCITY) {
            fixedX = 1;
        }

        fixedX *= Math.signum(player.getVelocity().x());

        if (player.getVelocity().y() > 0) {
            fixedY = 1;
        } else if (player.getVelocity().y() < 0) {
            fixedY = -1;
        }

        Vector2D fixedVelocity = new Vector2D(fixedX, fixedY);
        return new PlayerState(player.getPowerupBehaviour(), fixedVelocity);
    }

}
