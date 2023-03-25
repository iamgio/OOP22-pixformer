package pixformer.view.entity.player;

import java.util.List;

import pixformer.view.engine.Renderer;

public interface PlayerAnimation {
    List<Renderer> getIdleRenderer();
    List<Renderer> getWalkRenderer();
    List<Renderer> getRunRenderer();
}
