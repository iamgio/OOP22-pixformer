package pixformer.model.entity;

import pixformer.controller.deserialization.level.EntityType;
import pixformer.model.entity.dynamic.Goomba;
import pixformer.model.entity.statics.Block;
import pixformer.model.entity.statics.Brick;

import java.util.function.Consumer;

/**
 * {@inheritDoc}.
 */
public class EntityFactoryImpl implements EntityFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity createTileBlock(final int x, final int y) {
        return new Block(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @EntityType("grass")
    @Override
    public Entity createGrassBlock(final int x, final int y) {
        return new Block(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @EntityType("brick")
    @Override
    public Entity createBrickBlock(final int x, final int y) {
        return new Brick(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity createSurpriseBlock(final int x, final int y) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity createGoomba(final int x, final int y) {
        return new Goomba(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity createKoopa(final int x, final int y) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity createMainCharacter(final int x, final int y) {
        return null;
    }
}
