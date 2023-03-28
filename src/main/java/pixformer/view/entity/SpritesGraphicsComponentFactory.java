package pixformer.view.entity;

import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentFactory;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.view.entity.enemies.GoombaGraphicsComponent;
import pixformer.view.entity.enemies.TurtleGraphicsComponent;
import pixformer.view.entity.enemies.WalkingKoopaGraphicsComponent;
import pixformer.view.entity.player.PlayerGraphicsComponent;
import pixformer.view.entity.powerup.FireFlowerGraphicsComponent;
import pixformer.view.entity.statics.BlockGraphicsComponent;
import pixformer.view.entity.statics.CoinGraphicsComponent;
import pixformer.view.entity.statics.PoleGraphicsComponent;
import pixformer.view.entity.statics.GrassGraphicsComponent;
import pixformer.view.entity.statics.SurpriseGraphicsComponent;
import pixformer.view.entity.statics.BrickGraphicsComponent;

/**
 * A factory of graphics component represented by sprite images.
 */
public class SpritesGraphicsComponentFactory implements GraphicsComponentFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent tileBlock(final Entity entity) {
        return new BlockGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent grassBlock(final Entity entity) {
        return new GrassGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent brickBlock(final Entity entity) {
        return new BrickGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent surpriseBlock(final Entity entity) {
        return new SurpriseGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent coin(final Entity entity) {
        return new CoinGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent pole(final Entity entity) {
        return new PoleGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent goomba(final Entity entity) {
        return new GoombaGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent walkingKoopa(final Entity entity) {
        return new WalkingKoopaGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent turtleKoopa(final Entity entity) {
        return new TurtleGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent fireFlower(final Entity entity) {
        return new FireFlowerGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerGraphicsComponent player(final Player player) {
        return new PlayerGraphicsComponent(player);
    }
}
