package pixformer.model.entity;

/**
 * A factory for entities.
 */
public interface EntityFactory {

    /**
     * @return a grass block
     */
    DrawableEntity createGrassBlock();

    /**
     * @return a brick block
     */
    DrawableEntity createBrickBlock();

    /**
     * @return a surprise block
     */
    DrawableEntity createSurpriseBlock();

    /**
     * @return a gumba entity
     */
    DrawableEntity createGumba();

    /**
     * @return a turtle entity
     */
    DrawableEntity createTurtle();

    /**
     * @return a main character
     */
    DrawableEntity createMainCharacter();
}
