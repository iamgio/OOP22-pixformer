package pixformer.view.entity.player;

import java.util.List;

import pixformer.model.entity.dynamic.player.Player;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;

public interface PlayerAnimation {
    /**
     * @param factory the factory to create renders from.
     * @param player the player to animate.
     * @return an animation of a player in idle state.
     */
    List<Renderer> getIdleRenderer(RendererFactory factory, Player player);

    /**
     * @param factory the factory to create renders from.
     * @param player the player to animate.
     * @return an animation of a player in walking state.
     */
    List<Renderer> getWalkRenderer(RendererFactory factory, Player player);

    /**
     * @param factory the factory to create renders from.
     * @param player the player to animate.
     * @return an animation of a player in running state.
     */
    List<Renderer> getRunRenderer(RendererFactory factory, Player player);

    /**
     * @param factory the factory to create renders from.
     * @param player the player to animate.
     * @return an animation of a player in jumping state.
     */
    List<Renderer> getJumpRenderer(RendererFactory factory, Player player);
}
