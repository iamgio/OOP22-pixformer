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
                    factory.newImage("/sprites/player/mario_small_idle.png", player.getWidth(), player.getHeight())
                );
            }

            @Override
            public List<Renderer> getWalkRenderer(final RendererFactory factory, final Player player) {
                return List.of(
                    factory.newImage("/sprites/player/mario_small_walk_1.png", player.getWidth(), player.getHeight()),
                    factory.newImage("/sprites/player/mario_small_walk_2.png", player.getWidth(), player.getHeight()),
                    factory.newImage("/sprites/player/mario_small_walk_3.png", player.getWidth(), player.getHeight())
                );
            }

            @Override
            public List<Renderer> getRunRenderer(final RendererFactory factory, final Player player) {
                return List.of(
                    factory.newImage("/sprites/player/mario_small_walk_1.png", player.getWidth(), player.getHeight()),
                    factory.newImage("/sprites/player/mario_small_walk_2.png", player.getWidth(), player.getHeight()),
                    factory.newImage("/sprites/player/mario_small_walk_3.png", player.getWidth(), player.getHeight())
                );
            }

            @Override
            public List<Renderer> getJumpRenderer(RendererFactory factory, Player player) {
                return List.of(
                    factory.newImage("/sprites/player/mario_small_jump.png", player.getWidth(), player.getHeight())
                );
            }

        };
    }

    public PlayerAnimation getMushroomPlayerAnimation() {
        return new PlayerAnimation() {

            @Override
            public List<Renderer> getIdleRenderer(final RendererFactory factory, final Player player) {
                return List.of(
                    factory.newImage("/sprites/player/powerups/mushroom/mario_big_idle.png", player.getWidth(), player.getHeight())
                );
            }

            @Override
            public List<Renderer> getWalkRenderer(final RendererFactory factory, final Player player) {
                return List.of(
                    factory.newImage("/sprites/player/powerups/mushroom/mario_big_walk_1.png", player.getWidth(), player.getHeight()),
                    factory.newImage("/sprites/player/powerups/mushroom/mario_big_walk_2.png", player.getWidth(), player.getHeight()),
                    factory.newImage("/sprites/player/powerups/mushroom/mario_big_walk_3.png", player.getWidth(), player.getHeight())
                );
            }

            @Override
            public List<Renderer> getRunRenderer(final RendererFactory factory, final Player player) {
                return List.of(
                    factory.newImage("/sprites/player/powerups/mushroom/mario_big_walk_1.png", player.getWidth(), player.getHeight()),
                    factory.newImage("/sprites/player/powerups/mushroom/mario_big_walk_2.png", player.getWidth(), player.getHeight()),
                    factory.newImage("/sprites/player/powerups/mushroom/mario_big_walk_3.png", player.getWidth(), player.getHeight())
                );
            }

            @Override
            public List<Renderer> getJumpRenderer(RendererFactory factory, Player player) {
                return List.of(
                    factory.newImage("/sprites/player/powerups/mushroom/mario_big_jump.png", player.getWidth(), player.getHeight())
                );
            }

        };
    }

    public PlayerAnimation getFireFlowerPlayerAnimation() {
        return new PlayerAnimation() {

            @Override
            public List<Renderer> getIdleRenderer(final RendererFactory factory, final Player player) {
                return List.of(
                    factory.newImage("/sprites/player/powerups/fireflower/mario_flower_idle.png", player.getWidth(), player.getHeight())
                );
            }

            @Override
            public List<Renderer> getWalkRenderer(final RendererFactory factory, final Player player) {
                return List.of(
                    factory.newImage("/sprites/player/powerups/fireflower/mario_flower_walk_1.png", player.getWidth(), player.getHeight()),
                    factory.newImage("/sprites/player/powerups/fireflower/mario_flower_walk_2.png", player.getWidth(), player.getHeight()),
                    factory.newImage("/sprites/player/powerups/fireflower/mario_flower_walk_3.png", player.getWidth(), player.getHeight())
                );
            }

            @Override
            public List<Renderer> getRunRenderer(final RendererFactory factory, final Player player) {
                return List.of(
                    factory.newImage("/sprites/player/powerups/fireflower/mario_flower_walk_1.png", player.getWidth(), player.getHeight()),
                    factory.newImage("/sprites/player/powerups/fireflower/mario_flower_walk_2.png", player.getWidth(), player.getHeight()),
                    factory.newImage("/sprites/player/powerups/fireflower/mario_flower_walk_3.png", player.getWidth(), player.getHeight())
                );
            }

            @Override
            public List<Renderer> getJumpRenderer(RendererFactory factory, Player player) {
                return List.of(
                    factory.newImage("/sprites/player/powerups/fireflower/mario_flower_jump.png", player.getWidth(), player.getHeight())
                );
            }
            
        };
    }
}