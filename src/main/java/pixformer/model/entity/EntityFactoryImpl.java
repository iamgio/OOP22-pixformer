package pixformer.model.entity;

import pixformer.controller.deserialization.level.EntityType;
import pixformer.model.entity.dynamic.Goomba;
import pixformer.model.entity.dynamic.Koopa;
import pixformer.model.entity.statics.Block;
import pixformer.model.entity.statics.Brick;

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
    @EntityType("goomba")
    @Override
    public Entity createGoomba(final int x, final int y) {
        return new Goomba(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @EntityType("koopa")
    @Override
    public Entity createKoopa(final int x, final int y) {
        return new Koopa(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity createMainCharacter(final int x, final int y) {
        return null;
    }
}
