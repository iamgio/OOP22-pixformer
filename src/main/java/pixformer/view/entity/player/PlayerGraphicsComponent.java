package pixformer.view.entity.player;

import pixformer.view.engine.Color;

import java.util.List;
import java.util.Optional;

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
    private static final double IDLE_VELOCITY = 0.000_001;

    private final Player player;

    /**
     * 
     * @param player Player entity who will be displayed.
     */
    public PlayerGraphicsComponent(final Player player) {
        super(player, SWITCH_TIME);
        this.player = player;
    }

    /**
     * {@inheritDoc}
     * @implNote it saves the new renderers on cache at initialization
     */
    @Override
    protected List<Renderer> getRenderers(final RendererFactory factory) {
        return createRenderers(factory);
    }

    @Override
    protected List<Renderer> createRenderers(RendererFactory factory) {
        PlayerSpriteFactory spriteFactory = new PlayerSpriteFactory();
        PlayerAnimation animation = spriteFactory.getPlayerAnimation();

        Optional<PowerupBehaviour> currentPowerup = player.getPowerup().getBehaviour();
        if(currentPowerup.isEmpty()){
            animation = spriteFactory.getPlayerAnimation();
        } else if (currentPowerup.get() instanceof Mushroom) {
            animation = spriteFactory.getMushroomPlayerAnimation();
        } else if (currentPowerup.get() instanceof FireFlower) {
            animation = spriteFactory.getFireFlowerPlayerAnimation();
        }

        if (player.getVelocity().y() != 0) {
            return animation.getJumpRenderer(factory, player);
        }

        if(Math.abs(player.getVelocity().x()) > PlayerInputComponent.BASE_SPEED_LIMIT) {
            return animation.getRunRenderer(factory, player);
        }

        if (player.getVelocity().x() > IDLE_VELOCITY) {
            return animation.getWalkRenderer(factory, player);
        }

        return animation.getIdleRenderer(factory, player);
    }

}
