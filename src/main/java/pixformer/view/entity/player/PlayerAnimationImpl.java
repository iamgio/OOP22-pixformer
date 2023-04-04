package pixformer.view.entity.player;

import java.util.List;
import java.util.stream.Collectors;

import pixformer.model.entity.dynamic.player.Player;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;

public class PlayerAnimationImpl implements PlayerAnimation {
    final List<String> idleFramesPaths;
    final List<String> walkFramesPaths;
    final List<String> runFramesPaths;
    final List<String> jumpFramesPaths;


    public PlayerAnimationImpl(final List<String> idleFramesPaths, final List<String> walkFramesPaths, final List<String> runFramesPaths, final List<String> jumpFramesPaths) {
        this.idleFramesPaths = idleFramesPaths;
        this.walkFramesPaths = walkFramesPaths;
        this.runFramesPaths = runFramesPaths;
        this.jumpFramesPaths = jumpFramesPaths;
    }

    @Override
    public List<Renderer> getIdleRenderer(RendererFactory factory, Player player) {
        return genericRenderer(factory, player, idleFramesPaths);
    }

    @Override
    public List<Renderer> getWalkRenderer(RendererFactory factory, Player player) {
        return genericRenderer(factory, player, walkFramesPaths);
    }

    @Override
    public List<Renderer> getRunRenderer(RendererFactory factory, Player player) {
        return genericRenderer(factory, player, runFramesPaths);
    }

    @Override
    public List<Renderer> getJumpRenderer(RendererFactory factory, Player player) {
        return genericRenderer(factory, player, jumpFramesPaths);
    }

    private List<Renderer> genericRenderer(RendererFactory factory, Player player, List<String> paths) {
        return paths.stream()
                    .map(x -> factory.newImage(x, 
                                    player.getWidth(), player.getHeight(),
                                    player.getVelocity().x() < 0)).collect(Collectors.toList());
    }
    
}
