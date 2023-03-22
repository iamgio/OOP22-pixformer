package pixformer.model.entity;

import pixformer.controller.deserialization.level.EntityType;
import pixformer.model.entity.dynamic.Goomba;
import pixformer.model.entity.dynamic.Koopa;
import pixformer.model.entity.statics.*;

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
        return new Block(x, y, graphicsComponentFactory::tileBlock);
    }

    /**
     * {@inheritDoc}
     */
    @EntityType("grass")
    @Override
    public Entity createGrassBlock(final int x, final int y) {
        return new Block(x, y, graphicsComponentFactory::grassBlock);
    }

    /**
     * {@inheritDoc}
     */
    @EntityType("brick")
    @Override
    public Entity createBrickBlock(final int x, final int y) {
        return new Brick(x, y, graphicsComponentFactory::brickBlock);
    }

    /**
     * {@inheritDoc}
     */
    @EntityType("surprise")
    @Override
    public Entity createSurpriseBlock(final int x, final int y) {
        return new Surprise(x, y, graphicsComponentFactory::surpriseBlock);
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
    @EntityType("coin")
    @Override
    public Entity createCoin(final int x, final int y) {
        return new Coin(x, y, graphicsComponentFactory::coin);
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
