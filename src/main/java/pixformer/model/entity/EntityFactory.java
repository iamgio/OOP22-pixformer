package pixformer.model.entity;

import pixformer.common.Vector2D;

/**
 * A factory for entities.
 */
public interface EntityFactory {

    /**
     * @return a tile block
     */
    DrawableEntity createTileBlock(Vector2D position);

    /**
     * @return a grass block
     */
    DrawableEntity createGrassBlock(Vector2D position);

    /**
     * @return a brick block
     */
    DrawableEntity createBrickBlock(Vector2D position);

    /**
     * @return a surprise block
     */
    DrawableEntity createSurpriseBlock(Vector2D position);

    /**
     * @return a goomba entity
     */
    DrawableEntity createGoomba(Vector2D position);

    /**
     * @return a koopa entity
     */
    DrawableEntity createKoopa(Vector2D position);

    /**
     * @return a main character
     */
    DrawableEntity createMainCharacter(Vector2D position);
}
