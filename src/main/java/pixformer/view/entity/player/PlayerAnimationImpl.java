package pixformer.view.entity.player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import pixformer.model.entity.dynamic.player.Player;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;

/**
 * Implementation of PlayerAnimation interface.
 */
public class PlayerAnimationImpl implements PlayerAnimation {
    private final List<String> idleFramesPaths;
    private final List<String> walkFramesPaths;
    private final List<String> runFramesPaths;
    private final List<String> jumpFramesPaths;

    /**
     * @param idleFramesPaths list of frames paths for idle animation.
     * @param walkFramesPaths list of frames paths for walking animation.
     * @param runFramesPaths list of frames paths for running animation.
     * @param jumpFramesPaths list of frames paths for jumping animation.
     */
    public PlayerAnimationImpl(final List<String> idleFramesPaths, final List<String> walkFramesPaths,
                                final List<String> runFramesPaths, final List<String> jumpFramesPaths) {
        this.idleFramesPaths = Collections.unmodifiableList(idleFramesPaths);
        this.walkFramesPaths = Collections.unmodifiableList(walkFramesPaths);
        this.runFramesPaths = Collections.unmodifiableList(runFramesPaths);
        this.jumpFramesPaths = Collections.unmodifiableList(jumpFramesPaths);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Renderer> getIdleRenderer(final RendererFactory factory, final Player player) {
        return genericRenderer(factory, player, idleFramesPaths);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Renderer> getWalkRenderer(final RendererFactory factory, final Player player) {
        return genericRenderer(factory, player, walkFramesPaths);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Renderer> getRunRenderer(final RendererFactory factory, final Player player) {
        return genericRenderer(factory, player, runFramesPaths);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Renderer> getJumpRenderer(final RendererFactory factory, final Player player) {
        return genericRenderer(factory, player, jumpFramesPaths);
    }

    /**
     * Generic renderer of the given frames.
     * @param factory the factory to create renders from.
     * @param player the player to animate.
     * @param paths a list of frames paths.
     * @return a list of renderer from the given list.
     */
    private List<Renderer> genericRenderer(final RendererFactory factory, final Player player, final List<String> paths) {
        return paths.stream()
                    .map(x -> factory.newImage(x, 
                                    player.getWidth(), player.getHeight(),
                                    player.getVelocity().x() < 0)).collect(Collectors.toList());
    }

}
