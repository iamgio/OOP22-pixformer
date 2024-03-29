package pixformer.model.entity;

/**
 * A factory for {@link Entity}.
 */
public interface EntityFactory {

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return a tile block
     */
    Entity createTileBlock(int x, int y);

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return a grass block
     */
    Entity createGrassBlock(int x, int y);

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return a brick block
     */
    Entity createBrickBlock(int x, int y);

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return a surprise block
     */
    Entity createSurpriseBlock(int x, int y);

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return a barrier block
     */
    Entity createBarrierBlock(int x, int y);

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return a coin
     */
    Entity createCoin(int x, int y);

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return a pole
     */
    Entity createPole(int x, int y);

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return a Goomba entity
     */
    Entity createGoomba(int x, int y);

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @return a Koopa entity
     */
    Entity createKoopa(int x, int y);

    /**
     * @param x X coordinate
     * @param y Y coordinate
     * @param playerIndex index of the player
     * @return a main character
     */
    Entity createMainCharacter(double x, double y, int playerIndex);

    /**
     * @param shooter entity who shoot the fireball
     * @return a fireball
     */
    Entity createFireball(Entity shooter);
}
