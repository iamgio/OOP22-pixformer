package pixformer.view.entity.player;

import java.util.List;

import pixformer.model.entity.dynamic.player.Player;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;

public class PlayerSpriteFactory {
    public PlayerAnimation getPlayerAnimation() {
        return new PlayerAnimation() {

            @Override
            public List<Renderer> getIdleRenderer(final RendererFactory factory, final Player player) {
                return List.of(
                    
                );
            }

            @Override
            public List<Renderer> getWalkRenderer(final RendererFactory factory, final Player player) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getWalkRenderer'");
            }

            @Override
            public List<Renderer> getRunRenderer(final RendererFactory factory, final Player player) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getRunRenderer'");
            }

            @Override
            public List<Renderer> getJumpRenderer(RendererFactory factory, Player player) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getJumpRenderer'");
            }

        };
    }

    public PlayerAnimation getMushroomPlayerAnimation() {
        return new PlayerAnimation() {

            @Override
            public List<Renderer> getIdleRenderer(final RendererFactory factory, final Player player) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getIdleRenderer'");
            }

            @Override
            public List<Renderer> getWalkRenderer(final RendererFactory factory, final Player player) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getWalkRenderer'");
            }

            @Override
            public List<Renderer> getRunRenderer(final RendererFactory factory, final Player player) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getRunRenderer'");
            }

            @Override
            public List<Renderer> getJumpRenderer(RendererFactory factory, Player player) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getJumpRenderer'");
            }

        };
    }

    public PlayerAnimation getFireFlowerPlayerAnimation() {
        return new PlayerAnimation() {

            @Override
            public List<Renderer> getIdleRenderer(final RendererFactory factory, final Player player) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getIdleRenderer'");
            }

            @Override
            public List<Renderer> getWalkRenderer(final RendererFactory factory, final Player player) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getWalkRenderer'");
            }

            @Override
            public List<Renderer> getRunRenderer(final RendererFactory factory, final Player player) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getRunRenderer'");
            }

            @Override
            public List<Renderer> getJumpRenderer(RendererFactory factory, Player player) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getJumpRenderer'");
            }
            
        };
    }
}
