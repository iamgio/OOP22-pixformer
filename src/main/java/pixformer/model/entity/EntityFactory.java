package pixformer.model.entity;

import pixformer.common.Vector2D;

/**
 * A factory for entities.
 */
public interface EntityFactory {

    /**
     * @param position position in the space of the entity
     * @return a tile block
     */
    DrawableEntity createTileBlock(Vector2D position);

    /**
     * @param position position in the space of the entity
     * @return a grass block
     */
    DrawableEntity createGrassBlock(Vector2D position);

    /**
     * @param position position in the space of the entity
     * @return a brick block
     */
    DrawableEntity createBrickBlock(Vector2D position);

    /**
     * @param position position in the space of the entity
     * @return a surprise block
     */
    DrawableEntity createSurpriseBlock(Vector2D position);

    /**
     * @param position position in the space of the entity
     * @return a goomba entity
     */
    DrawableEntity createGoomba(Vector2D position);

    /**
     * @param position position in the space of the entity
     * @return a koopa entity
     */
    DrawableEntity createKoopa(Vector2D position);

    /**
     * @param position position in the space of the entity
     * @return a main character
     */
    DrawableEntity createMainCharacter(Vector2D position);
}
