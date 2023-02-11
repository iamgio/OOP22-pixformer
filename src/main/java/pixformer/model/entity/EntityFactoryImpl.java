package pixformer.model.entity;

import pixformer.common.Vector2D;
import pixformer.model.entity.statics.Block;
import pixformer.model.entity.statics.Brick;
import pixformer.model.entity.statics.Surprise;

/**
 * {@inheritDoc}
 */
public class EntityFactoryImpl implements EntityFactory{

    /**
     * {@inheritDoc}
     */
    @Override
    public DrawableEntity createTileBlock(final Vector2D position) {
        return new Block(position, 1, 1, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DrawableEntity createGrassBlock(final Vector2D position) {
        return new Block(position, 1, 1, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DrawableEntity createBrickBlock(final Vector2D position) {
        return new Brick(position, 1, 1, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DrawableEntity createSurpriseBlock(final Vector2D position) {
        return new Surprise(position, 1, 1, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DrawableEntity createGoomba(final Vector2D position) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DrawableEntity createKoopa(final Vector2D position) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DrawableEntity createMainCharacter(final Vector2D position) {
        return null;
    }
}
