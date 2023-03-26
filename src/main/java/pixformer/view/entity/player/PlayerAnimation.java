package pixformer.view.entity.player;

import java.util.List;

import pixformer.model.entity.dynamic.player.Player;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;

public interface PlayerAnimation {
    List<Renderer> getIdleRenderer(final RendererFactory factory, final Player player);
    List<Renderer> getWalkRenderer(final RendererFactory factory, final Player player);
    List<Renderer> getRunRenderer(final RendererFactory factory, final Player player);
    List<Renderer> getJumpRenderer(final RendererFactory factory, final Player player);
}
