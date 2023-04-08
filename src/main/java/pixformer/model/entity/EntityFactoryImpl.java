package pixformer.model.entity;

import pixformer.controller.deserialization.level.EntityType;
import pixformer.model.World;
import pixformer.model.entity.dynamic.enemy.goomba.Goomba;
import pixformer.model.entity.dynamic.enemy.koopa.turtle.TurtleKoopa;
import pixformer.model.entity.dynamic.enemy.koopa.walking.WalkingKoopa;
import pixformer.model.entity.dynamic.player.PlayerImpl;
import pixformer.model.entity.dynamic.powerup.FlowerPowerupEntity;
import pixformer.model.entity.dynamic.powerup.MovingPowerupEntity;
import pixformer.model.entity.powerup.other.fireball.Fireball;
import pixformer.model.entity.powerup.powerups.Mushroom;
import pixformer.model.entity.statics.Barrier;
import pixformer.model.entity.statics.Block;
import pixformer.model.entity.statics.brick.Brick;
import pixformer.model.entity.statics.coin.Coin;
import pixformer.model.entity.statics.pole.Pole;
import pixformer.model.entity.statics.surprise.Surprise;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * {@inheritDoc}.
 */
public class EntityFactoryImpl implements EntityFactory, PowerUpFactory, TurtleKoopaFactory {

    private final GraphicsComponentFactory graphicsComponentFactory;
    private final Consumer<Entity> addEntityToWorld;
    private final BiConsumer<Entity, Entity> removeEntityFromWorld;

    /**
     * Simple constructor for the Entity factory.
     *
     * @param graphicsComponentFactory the factory to get the graphics components from
     * @param world                    world where the entities live in
     */
    public EntityFactoryImpl(final GraphicsComponentFactory graphicsComponentFactory, final World world) {
        this.graphicsComponentFactory = graphicsComponentFactory;
        this.addEntityToWorld = world::queueEntitySpawn;
        this.removeEntityFromWorld = world::queueEntityKill;
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
        return new Surprise(x, y, graphicsComponentFactory::surpriseBlock, this);
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
    @EntityType("pole")
    @Override
    public Entity createPole(final int x, final int y) {
        return new Pole(x, y, graphicsComponentFactory::pole);
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
    @Override
    public Entity createTurtleKoopa(final double x, final double y, final Entity shooter) {
        return new TurtleKoopa(x, y, shooter, removeEntityFromWorld, graphicsComponentFactory::turtleKoopa);
    }

    /**
     * {@inheritDoc}
     */
    @EntityType("koopa")
    @Override
    public Entity createKoopa(final int x, final int y) {
        return new WalkingKoopa(
                x, y,
                (xx, yy, shooter) -> addEntityToWorld.accept(createTurtleKoopa(xx, yy, shooter)),
                removeEntityFromWorld,
                graphicsComponentFactory::walkingKoopa
        );
    }

    /**
     * {@inheritDoc}
     */
    @EntityType("player")
    @Override
    public PlayerImpl createMainCharacter(final double x, final double y, final int playerIndex) {
        final PlayerImpl player = new PlayerImpl(x, y, playerIndex, this);
        player.setGraphicsComponent(graphicsComponentFactory.player(player));
        return player;
    }

    /**
     * {@inheritDoc}
     */
    @EntityType("fire_flower")
    @Override
    public Entity createFireFlower(final int x, final int y) {
        return new FlowerPowerupEntity(x, y, removeEntityFromWorld, graphicsComponentFactory::fireFlower);
    }

    /**
     * {@inheritDoc}
     */
    @EntityType("mushroom")
    @Override
    public Entity createMushroom(final int x, final int y) {
        return new MovingPowerupEntity(x, y, removeEntityFromWorld, new Mushroom(),
                graphicsComponentFactory::redMushroom);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity createFireball(final Entity shooter) {
        return new Fireball(shooter, graphicsComponentFactory::fireball);
    }
}
