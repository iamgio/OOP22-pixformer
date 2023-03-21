package pixformer.model.entity;

import pixformer.controller.deserialization.level.EntityType;
import pixformer.model.entity.dynamic.Goomba;
import pixformer.model.entity.dynamic.Koopa;
import pixformer.model.entity.statics.Barrier;
import pixformer.model.entity.statics.Block;
import pixformer.model.entity.statics.Brick;
import pixformer.model.entity.statics.Surprise;

/**
 * {@inheritDoc}.
 */
public class EntityFactoryImpl implements EntityFactory {

    private final GraphicsComponentFactory graphicsComponentFactory;

    /**
     * @param graphicsComponentFactory the factory to get the graphics components from
     */
    public EntityFactoryImpl(final GraphicsComponentFactory graphicsComponentFactory) {
        this.graphicsComponentFactory = graphicsComponentFactory;
    }

    /**
     * {@inheritDoc}
     */
    @EntityType("block")
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
    @EntityType("surprise")
    @Override
    public Entity createSurpriseBlock(final int x, final int y) {
        return new Surprise(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @EntityType("barrier")
    @Override
    public Entity createBarrierBlock(final int x, final int y) {
        return new Barrier(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @EntityType("goomba")
    @Override
    public Entity createGoomba(final int x, final int y) {
        return new Goomba(x, y, graphicsComponentFactory::goomba);
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
    @EntityType("player")
    @Override
    public Entity createMainCharacter(final int x, final int y) {
        return null;
    }
}
