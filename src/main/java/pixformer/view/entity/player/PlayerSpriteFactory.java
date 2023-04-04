package pixformer.view.entity.player;

import java.util.List;

/**
 * A factory of player animations, sorted by player powerup.
 */
public class PlayerSpriteFactory {

    private static final String BASE_PATH = "/sprites/player/";

    /**
     * @return animations for a player without powerup.
     */
    public PlayerAnimation getPlayerAnimation() {
        final List<String> idleFramesPaths = List.of(BASE_PATH + "mario_small_idle.png");
        final List<String> walkFramesPaths = List.of(BASE_PATH + "mario_small_walk_1.png",
                                                    BASE_PATH + "mario_small_walk_2.png",
                                                    BASE_PATH +  "mario_small_walk_3.png");
        final List<String> runFramesPaths = List.of(BASE_PATH + "mario_small_walk_1.png",
                                                    BASE_PATH + "mario_small_walk_2.png",
                                                    BASE_PATH +  "mario_small_walk_3.png");
        final List<String> jumpFramesPaths = List.of(BASE_PATH + "mario_small_jump.png");

        return new PlayerAnimationImpl(idleFramesPaths, walkFramesPaths, runFramesPaths, jumpFramesPaths);
    }

    /**
     * @return animations for a player holding Mushroom powerup.
     */
    public PlayerAnimation getMushroomPlayerAnimation() {

        final List<String> idleFramesPaths = List.of(BASE_PATH + "powerups/mushroom/mario_big_idle.png");
        final List<String> walkFramesPaths = List.of(BASE_PATH + "powerups/mushroom/mario_big_walk_1.png",
                                                    BASE_PATH + "powerups/mushroom/mario_big_walk_2.png",
                                                    BASE_PATH +  "powerups/mushroom/mario_big_walk_3.png");
        final List<String> runFramesPaths = List.of(BASE_PATH + "powerups/mushroom/mario_big_walk_1.png",
                                                    BASE_PATH + "powerups/mushroom/mario_big_walk_2.png",
                                                    BASE_PATH +  "powerups/mushroom/mario_big_walk_3.png");
        final List<String> jumpFramesPaths = List.of(BASE_PATH + "powerups/mushroom/mario_big_jump.png");

        return new PlayerAnimationImpl(idleFramesPaths, walkFramesPaths, runFramesPaths, jumpFramesPaths);
    }

    /**
     * @return animations for a player holding Fire-flower powerup.
     */
    public PlayerAnimation getFireFlowerPlayerAnimation() {

        final List<String> idleFramesPaths = List.of(BASE_PATH + "powerups/fireflower/mario_flower_idle.png");
        final List<String> walkFramesPaths = List.of(BASE_PATH + "powerups/fireflower/mario_flower_walk_1.png",
                                                    BASE_PATH + "powerups/fireflower/mario_flower_walk_2.png",
                                                    BASE_PATH +  "powerups/fireflower/mario_flower_walk_3.png");
        final List<String> runFramesPaths = List.of(BASE_PATH + "powerups/fireflower/mario_flower_walk_1.png",
                                                    BASE_PATH + "powerups/fireflower/mario_flower_walk_2.png",
                                                    BASE_PATH +  "powerups/fireflower/mario_flower_walk_3.png");
        final List<String> jumpFramesPaths = List.of(BASE_PATH + "powerups/fireflower/mario_flower_jump.png");

        return new PlayerAnimationImpl(idleFramesPaths, walkFramesPaths, runFramesPaths, jumpFramesPaths);
    }
}
