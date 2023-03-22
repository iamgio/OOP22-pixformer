package pixformer.model.entity;

/**
 * Factory for {@link pixformer.model.entity.powerup.PowerUp}.
 */
public interface PowerUpFactory {

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return a flower powerup.
     */
    Entity createFireFlower(int x, int y);

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return a mushroom powerup.
     */
    Entity createMushroom(int x, int y);
}
